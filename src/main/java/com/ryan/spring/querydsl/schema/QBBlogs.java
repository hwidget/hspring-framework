package com.ryan.spring.querydsl.schema;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBBlogs is a Querydsl query type for QBBlogs
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QBBlogs extends com.querydsl.sql.RelationalPathBase<QBBlogs> {

    private static final long serialVersionUID = -1163081992;

    public static final QBBlogs bBlogs = new QBBlogs("b_blogs");

    public final StringPath blogId = createString("blogId");

    public final StringPath blogTitle = createString("blogTitle");

    public final NumberPath<Integer> categoryId = createNumber("categoryId", Integer.class);

    public final StringPath context = createString("context");

    public final StringPath createdByUser = createString("createdByUser");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> publishDate = createDateTime("publishDate", java.sql.Timestamp.class);

    public final com.querydsl.sql.PrimaryKey<QBBlogs> primary = createPrimaryKey(blogId);

    public final com.querydsl.sql.ForeignKey<QBCategorys> blogsCategorys = createForeignKey(categoryId, "category_id");

    public final com.querydsl.sql.ForeignKey<QBComments> _blogsCommentsPk = createInvForeignKey(blogId, "blog_id");

    public QBBlogs(String variable) {
        super(QBBlogs.class, forVariable(variable), "null", "b_blogs");
        addMetadata();
    }

    public QBBlogs(String variable, String schema, String table) {
        super(QBBlogs.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBBlogs(String variable, String schema) {
        super(QBBlogs.class, forVariable(variable), schema, "b_blogs");
        addMetadata();
    }

    public QBBlogs(Path<? extends QBBlogs> path) {
        super(path.getType(), path.getMetadata(), "null", "b_blogs");
        addMetadata();
    }

    public QBBlogs(PathMetadata metadata) {
        super(QBBlogs.class, metadata, "null", "b_blogs");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(blogId, ColumnMetadata.named("blog_id").withIndex(1).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(blogTitle, ColumnMetadata.named("blog_title").withIndex(2).ofType(Types.VARCHAR).withSize(200));
        addMetadata(categoryId, ColumnMetadata.named("category_id").withIndex(5).ofType(Types.INTEGER).withSize(10));
        addMetadata(context, ColumnMetadata.named("context").withIndex(3).ofType(Types.LONGVARCHAR).withSize(65535));
        addMetadata(createdByUser, ColumnMetadata.named("created_by_user").withIndex(7).ofType(Types.VARCHAR).withSize(50));
        addMetadata(createdDate, ColumnMetadata.named("created_date").withIndex(6).ofType(Types.TIMESTAMP).withSize(19));
        addMetadata(publishDate, ColumnMetadata.named("publish_date").withIndex(4).ofType(Types.TIMESTAMP).withSize(19));
    }

}

