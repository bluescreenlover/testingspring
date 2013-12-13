package id.co.sambaltomat.core.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: sambaltomat
 * Date: 12/10/13
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "M_ROLES")
public class Roles implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = -4740730508296468648L;

    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(name = "NAMA")
    private String name;

    @Column(name = "KETERANGAN")
    private String keterangan;

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ROLE_MENU",
            joinColumns = {@JoinColumn(name = "ROLE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "MENU_ID")}
    )
    private Set<Menu> menu;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    /*public Set<Menu> getMenu() {
        return menu;
    }

    public void setMenu(Set<Menu> menu) {
        this.menu = menu;
    }*/

    public String getAuthority() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roles)) return false;

        Roles roles = (Roles) o;

        if (!id.equals(roles.id)) return false;
        if (keterangan != null ? !keterangan.equals(roles.keterangan) : roles.keterangan != null) return false;
        /*if (menu != null ? !menu.equals(roles.menu) : roles.menu != null) return false;*/
        if (!name.equals(roles.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (keterangan != null ? keterangan.hashCode() : 0);
        /*result = 31 * result + (menu != null ? menu.hashCode() : 0);*/
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Roles{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", keterangan='").append(keterangan).append('\'');
        /*sb.append(", menu=").append(menu);*/
        sb.append('}');
        return sb.toString();
    }
}
