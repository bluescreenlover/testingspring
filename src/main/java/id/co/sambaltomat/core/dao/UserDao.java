package id.co.sambaltomat.core.dao;

import id.co.sambaltomat.core.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: sambaltomat
 * Date: 12/10/13
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao extends GenericDao<User, Long> {

    /**
     * Gets users information based on login name.
     *
     * @param username the user's username
     * @return userDetails populated userDetails object
     * @throws org.springframework.security.core.userdetails.UsernameNotFoundException
     *          thrown when user not found in database
     */
    @Transactional
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
