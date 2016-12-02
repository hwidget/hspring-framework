package com.ryan.spring.web.blog.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Rayn on 2016/7/2.
 * @email liuwei412552703@163.com.
 */
@Entity
@Table(name = "b_categorys")
public class CategorysEntity {
    private Integer categoryId;
    private String categoryName;
    private Integer categoryOrder;
    private Timestamp createdDate;
    private String createdByUser;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "category_order")
    public Integer getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(Integer categoryOrder) {
        this.categoryOrder = categoryOrder;
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

        CategorysEntity entity = (CategorysEntity) o;

        if (categoryId != entity.categoryId) return false;
        if (categoryName != null ? !categoryName.equals(entity.categoryName) : entity.categoryName != null) return false;
        if (categoryOrder != null ? !categoryOrder.equals(entity.categoryOrder) : entity.categoryOrder != null) return false;
        if (createdDate != null ? !createdDate.equals(entity.createdDate) : entity.createdDate != null) return false;
        if (createdByUser != null ? !createdByUser.equals(entity.createdByUser) : entity.createdByUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (categoryOrder != null ? categoryOrder.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        return result;
    }
}
