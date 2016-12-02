package com.ryan.spring.web.blog.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Rayn on 2016/7/2.
 * @email liuwei412552703@163.com.
 */
@Entity
@Table(name = "b_users")
public class UsersEntity {
    private Integer userId;
    private String nikename;
    private String loginname;
    private String loginpass;
    private String email;
    private Integer age;
    private String contacts;
    private Byte isDisable;
    private Timestamp createdDate;
    private String createdByUser;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "nikename")
    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    @Basic
    @Column(name = "loginname")
    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    @Basic
    @Column(name = "loginpass")
    public String getLoginpass() {
        return loginpass;
    }

    public void setLoginpass(String loginpass) {
        this.loginpass = loginpass;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "contacts")
    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Basic
    @Column(name = "is_disable")
    public Byte getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Byte isDisable) {
        this.isDisable = isDisable;
    }

    @Basic
    @Column(name = "created_date")
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "created_by_user")
    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity entity = (UsersEntity) o;

        if (userId != entity.userId) return false;
        if (nikename != null ? !nikename.equals(entity.nikename) : entity.nikename != null) return false;
        if (loginname != null ? !loginname.equals(entity.loginname) : entity.loginname != null) return false;
        if (loginpass != null ? !loginpass.equals(entity.loginpass) : entity.loginpass != null) return false;
        if (email != null ? !email.equals(entity.email) : entity.email != null) return false;
        if (age != null ? !age.equals(entity.age) : entity.age != null) return false;
        if (contacts != null ? !contacts.equals(entity.contacts) : entity.contacts != null) return false;
        if (isDisable != null ? !isDisable.equals(entity.isDisable) : entity.isDisable != null) return false;
        if (createdDate != null ? !createdDate.equals(entity.createdDate) : entity.createdDate != null) return false;
        if (createdByUser != null ? !createdByUser.equals(entity.createdByUser) : entity.createdByUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (nikename != null ? nikename.hashCode() : 0);
        result = 31 * result + (loginname != null ? loginname.hashCode() : 0);
        result = 31 * result + (loginpass != null ? loginpass.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        result = 31 * result + (isDisable != null ? isDisable.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        return result;
    }
}
