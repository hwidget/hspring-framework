package com.ryan.spring.web.blog.dao.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Rayn on 2016/7/2.
 * @email liuwei412552703@163.com.
 */
@Entity
@Table(name = "b_comments" )
public class CommentsEntity {
    private String commentId;
    private String commentContext;
    private String nikename;
    private String email;
    private Timestamp publishDate;
    private Byte likes;
    private Byte trolling;
    private Integer topOrder;
    private String pCommentId;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @GeneratedValue(generator = "generator")
    @Id
    @Column(name = "comment_id")
    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "comment_context")
    public String getCommentContext() {
        return commentContext;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "likes")
    public Byte getLikes() {
        return likes;
    }

    public void setLikes(Byte likes) {
        this.likes = likes;
    }

    @Basic
    @Column(name = "trolling")
    public Byte getTrolling() {
        return trolling;
    }

    public void setTrolling(Byte trolling) {
        this.trolling = trolling;
    }

    @Basic
    @Column(name = "top_order")
    public Integer getTopOrder() {
        return topOrder;
    }

    public void setTopOrder(Integer topOrder) {
        this.topOrder = topOrder;
    }

    @Basic
    @Column(name = "p_comment_id")
    public String getpCommentId() {
        return pCommentId;
    }

    public void setpCommentId(String pCommentId) {
        this.pCommentId = pCommentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentsEntity entity = (CommentsEntity) o;

        if (commentId != null ? !commentId.equals(entity.commentId) : entity.commentId != null) return false;
        if (commentContext != null ? !commentContext.equals(entity.commentContext) : entity.commentContext != null) return false;
        if (nikename != null ? !nikename.equals(entity.nikename) : entity.nikename != null) return false;
        if (email != null ? !email.equals(entity.email) : entity.email != null) return false;
        if (publishDate != null ? !publishDate.equals(entity.publishDate) : entity.publishDate != null) return false;
        if (likes != null ? !likes.equals(entity.likes) : entity.likes != null) return false;
        if (trolling != null ? !trolling.equals(entity.trolling) : entity.trolling != null) return false;
        if (topOrder != null ? !topOrder.equals(entity.topOrder) : entity.topOrder != null) return false;
        if (pCommentId != null ? !pCommentId.equals(entity.pCommentId) : entity.pCommentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId != null ? commentId.hashCode() : 0;
        result = 31 * result + (commentContext != null ? commentContext.hashCode() : 0);
        result = 31 * result + (nikename != null ? nikename.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (likes != null ? likes.hashCode() : 0);
        result = 31 * result + (trolling != null ? trolling.hashCode() : 0);
        result = 31 * result + (topOrder != null ? topOrder.hashCode() : 0);
        result = 31 * result + (pCommentId != null ? pCommentId.hashCode() : 0);
        return result;
    }
}
