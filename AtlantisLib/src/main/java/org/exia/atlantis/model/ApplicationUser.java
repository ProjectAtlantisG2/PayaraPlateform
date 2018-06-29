package org.exia.atlantis.model;

import org.springframework.data.annotation.Id;

/**
 * Created by Azerom on 29/06/2018.
 */
public class ApplicationUser {

    @Id
    private String id;

    private String eliotId;

    private String firstName;
    private String lastName;

    private String eliotChain;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getEliotId() {
        return eliotId;
    }

    public void setEliotId(String eliotId) {
        this.eliotId = eliotId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEliotChain() {
        return eliotChain;
    }

    public void setEliotChain(String eliotChain) {
        this.eliotChain = eliotChain;
    }
}