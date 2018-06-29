package org.exia.atlantis.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by Azerom on 29/06/2018.
 */
public class User {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public Token lastToken;



}

class Token {
    public Date tokenDateTime;
    public String token;
}