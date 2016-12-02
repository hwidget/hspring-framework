package com.ryan.spring.web.blog.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Rayn on 2016/7/2.
 * @email liuwei412552703@163.com.
 */
@Entity
@Table(name = "b_blogs")
public class BlogsEntity {
    private String blogId;
    private String blogTitle;
    private String context;
    private Timestamp publishDate;
    private Timestamp createdDate;
    private String createdByUser;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Id
    @Column(name = "blog_id")
    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    @Basic
    @Column(name = "blog_title")
    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    @Basic
    @Column(name = "context")
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Basic
    @Column(name = "publish_date")
    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
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

        BlogsEntity entity = (BlogsEntity) o;

        if (blogId != null ? !blogId.equals(entity.blogId) : entity.blogId != null) return false;
        if (blogTitle != null ? !blogTitle.equals(entity.blogTitle) : entity.blogTitle != null) return false;
        if (context != null ? !context.equals(entity.context) : entity.context != null) return false;
        if (publishDate != null ? !publishDate.equals(entity.publishDate) : entity.publishDate != null) return false;
        if (createdDate != null ? !createdDate.equals(entity.createdDate) : entity.createdDate != null) return false;
        if (createdByUser != null ? !createdByUser.equals(entity.createdByUser) : entity.createdByUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = blogId != null ? blogId.hashCode() : 0;
        result = 31 * result + (blogTitle != null ? blogTitle.hashCode() : 0);
        result = 31 * result + (context != null ? context.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (createdByUser != null ? createdByUser.hashCode() : 0);
        return result;
    }
}
