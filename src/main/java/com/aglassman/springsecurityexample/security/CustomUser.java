package com.aglassman.springsecurityexample.security;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import static com.aglassman.springsecurityexample.security.CustomAuthorities.*;

@Entity
@Table(name = "USER")
public class CustomUser implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    public boolean isEmployee;

    @Column(nullable = false)
    public boolean isVendor;

    @Column(nullable = false)
    public boolean isPreferred;


    @Column(nullable = false)
    public boolean canReport;

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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        LinkedList<GrantedAuthority> authorities = new LinkedList();

        if(isEmployee) {
            authorities.add(EMPLOYEE);
        }

        if(isVendor) {
            authorities.add(VENDOR);
        }

        if(isPreferred) {
            authorities.add(PREFERRED_VENDOR);
        }

        return authorities;
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

    public boolean canAccessReports() {
        return canReport;
    }

    public boolean isCanReport() {
        return canReport;
    }

    public void setCanReport(boolean canReport) {
        this.canReport = canReport;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomUser{");
        sb.append("id=").append(id);
        sb.append(", isEmployee=").append(isEmployee);
        sb.append(", isVendor=").append(isVendor);
        sb.append(", isPreferred=").append(isPreferred);
        sb.append(", canReport=").append(canReport);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomUser that = (CustomUser) o;
        return isEmployee == that.isEmployee &&
            isVendor == that.isVendor &&
            isPreferred == that.isPreferred &&
            canReport == that.canReport &&
            Objects.equals(id, that.id) &&
            Objects.equals(username, that.username) &&
            Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, isEmployee, isVendor, isPreferred, canReport, username, password);
    }
}
