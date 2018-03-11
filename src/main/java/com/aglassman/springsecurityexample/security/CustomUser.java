package com.aglassman.springsecurityexample.security;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER")
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    public boolean isEmployee;

    @Column(nullable = false)
    public boolean isVendor;

    @Column(nullable = false)
    public boolean isPreferred;

    @Column(nullable = false, unique = true)
    public String username;

    // Don't store plain text, this is just a sample app
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public boolean isVendor() {
        return isVendor;
    }

    public void setVendor(boolean vendor) {
        isVendor = vendor;
    }

    public boolean isPreferred() {
        return isPreferred;
    }

    public void setPreferred(boolean preferred) {
        isPreferred = preferred;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "id=" + id +
                ", isEmployee=" + isEmployee +
                ", isVendor=" + isVendor +
                ", isPreferred=" + isPreferred +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUser that = (CustomUser) o;
        return isEmployee == that.isEmployee &&
                isVendor == that.isVendor &&
                isPreferred == that.isPreferred &&
                Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, isEmployee, isVendor, isPreferred, username, password);
    }
}
