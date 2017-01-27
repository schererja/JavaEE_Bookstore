package com.jrscherer.final_distjava.jsf;

import com.jrscherer.final_distjava.model.Users;
import com.jrscherer.final_distjava.ejb.UsersFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
/**
 * Users Controller made to talk between jpa and jsf.
 * NOTE: Not implemented into any JSF at the moment.
 * 
 * @author schereja
 */
@Named("usersController")
@SessionScoped
public class UsersController implements Serializable {
    private List<Users> users;
    private Users user;
    
    @Inject
    private UsersFacade userEao;
/**
 * Loads the users into users with a PostConstruct
 * 
 */    
    @PostConstruct
    public void loadUsers(){
        users =getUserEao().findAll();
    }
/**
 * Basic Constructor
 * 
 */
    public UsersController() {
    }
/**
 * Getter for users
 * 
 * @return Returns a List<Users>
 */
    public List<Users> getUsers() {
        return users;
    }
/**
 * Setter users
 * 
 * @param users Requires a List<Users>  
 */
    public void setUsers(List<Users> users) {
        this.users = users;
    }
/**
 *  Getter for User
 * 
 * @return Returns a Users object
 */
    public Users getUser() {
        return user;
    }
/**
 *  Setter for user
 * 
 * @param user Requires a Users object
 */
    public void setUser(Users user) {
        this.user = user;
    }
/**
 * Getter for userEao
 * 
 * @return Returns UsersFacade obect
 */
    public UsersFacade getUserEao() {
        return userEao;
    }
/**
 * Setter for userEao
 * 
 * @param userEao Requires a UsersFacade
 */
    public void setUserEao(UsersFacade userEao) {
        this.userEao = userEao;
    }
    
}
