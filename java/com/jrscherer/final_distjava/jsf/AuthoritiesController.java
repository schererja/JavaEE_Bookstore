package com.jrscherer.final_distjava.jsf;

import com.jrscherer.final_distjava.model.Authorities;
import com.jrscherer.final_distjava.ejb.AuthoritiesFacade;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 * Authorities Controller, basic class used to find all authorities
 *
 * @author schereja
 */
@Named("authoritiesController")
@SessionScoped
public class AuthoritiesController implements Serializable {

    private List<Authorities> authorities;
    private Authorities authority;

    @Inject
    private AuthoritiesFacade authoritiesEao;

    /**
     * Constructor used to create AuthoritiesController objects
     *
     */
    public AuthoritiesController() {
    }

    /**
     * Loads all the authorities Also has a PostConstruct
     *
     */
    @PostConstruct
    public void loadAuthorities() {
        authorities = getAuthoritiesEao().findAll();
    }

    /**
     * Getter to return the list of Authorities
     *
     * @return Returns a list of authorities
     */
    public List<Authorities> getAuthorities() {
        return authorities;
    }

    /**
     * Setter for the Authorities
     *
     * @param authorities Requires a list of Authorities
     */
    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    /**
     * Getter for Authorities
     *
     * @return Returns the authority object
     */
    public Authorities getAuthority() {
        return authority;
    }

    /**
     * Setter for Authority
     *
     * @param authority Requires an authority object
     */
    public void setAuthority(Authorities authority) {
        this.authority = authority;
    }

    /**
     * Getter for the authoritiesFacade
     *
     * @return returns the AuthoritiesFacade
     */
    public AuthoritiesFacade getAuthoritiesEao() {
        return authoritiesEao;
    }

    /**
     * Setter for the AuthoritiesEao
     *
     * @param authoritiesEao Requires an AuthoritiesFacade
     */
    public void setAuthoritiesEao(AuthoritiesFacade authoritiesEao) {
        this.authoritiesEao = authoritiesEao;
    }

}
