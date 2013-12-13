package id.co.sambaltomat.core.dao.hibernate;

import id.co.sambaltomat.core.dao.UserDao;
import id.co.sambaltomat.core.model.User;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sambaltomat
 * Date: 12/10/13
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoHibernate extends GenericDaoHibernate<User, Long> implements UserDao, UserDetailsService {
    public UserDaoHibernate() {
        super(User.class);
    }

    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return (UserDetails) getHibernateTemplate().execute(new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(User.class)
                        .setFetchMode("roles", FetchMode.SELECT)
                        .add(Restrictions.eq("username",username));

                List users = criteria.list();

                if (users==null || users.isEmpty()) {
                    throw new UsernameNotFoundException("User '" + username + "' not found...");
                }
                else{
                    User user = (User) users.get(0);

                    if (!user.isEnabled()) {
                        throw new DisabledException("user " + user.getUsername() + " is inactive");
                    }
                    Hibernate.initialize(user.getRole());
                    return user;
                }
            }
        });
    }
}
