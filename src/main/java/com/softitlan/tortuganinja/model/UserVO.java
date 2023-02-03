package com.softitlan.tortuganinja.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_user")
@NamedQueries({
        @NamedQuery(name = "UserVO.getUser", query = "SELECT c FROM UserVO as c"),
        @NamedQuery(name = "UserVO.verifyUserExist", query = "SELECT c FROM UserVO as c WHERE c.username = :username ")
})
public class UserVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;

    @Column
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
