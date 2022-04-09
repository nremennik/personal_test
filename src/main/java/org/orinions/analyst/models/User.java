package org.orinions.analyst.models;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
public class User // implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "login", nullable=false)
    private String login;
//    @Column(name = "password", nullable=false)
//    private String password;
//    @Column(name = "email", nullable = true)
//    private long email;
    @Column(name = "telephone", nullable = true)
    private String telephone;

    @Transient
    private String passwordConfirm;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User()
    {
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getLogin()
    {
        return login;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

//    @Override
//    public String getUsername()
//    {
//        return getLogin();
//    }
//
//    @Override
//    public boolean isAccountNonExpired()
//    {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked()
//    {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired()
//    {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled()
//    {
//        return true;
//    }
//
//    public void setLogin(String login)
//    {
//        this.login = login;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities()
//    {
//        return getRoles();
//    }
//
//    @Override
//    public String getPassword()
//    {
//        return password;
//    }

//    public String getPasswordConfirm()
//    {
//        return passwordConfirm;
//    }
//
//    public void setPasswordConfirm(String passwordConfirm)
//    {
//        this.passwordConfirm = passwordConfirm;
//    }

//    public Set<Role> getRoles()
//    {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles)
//    {
//        this.roles = roles;
//    }
}