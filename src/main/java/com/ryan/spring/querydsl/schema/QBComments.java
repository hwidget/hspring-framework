package com.ryan.spring.querydsl.schema;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBComments is a Querydsl query type for QBComments
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QBComments extends com.querydsl.sql.RelationalPathBase<QBComments> {

    private static final long serialVersionUID = -1816117587;

    public static final QBComments bComments = new QBComments("b_comments");

    public final StringPath blogId = createString("blogId");

    public final StringPath commentContext = createString("commentContext");

    public final StringPath commentId = createString("commentId");

    public final StringPath email = createString("email");

    public final NumberPath<Byte> likes = createNumber("likes", Byte.class);

    public final StringPath nikename = createString("nikename");

    public final StringPath pCommentId = createString("pCommentId");

    public final DateTimePath<java.sql.Timestamp> publishDate = createDateTime("publishDate", java.sql.Timestamp.class);

    public final NumberPath<Integer> topOrder = createNumber("topOrder", Integer.class);

    public final NumberPath<Byte> trolling = createNumber("trolling", Byte.class);

    public final com.querydsl.sql.PrimaryKey<QBComments> primary = createPrimaryKey(commentId);

    public final com.querydsl.sql.ForeignKey<QBBlogs> blogsCommentsPk = createForeignKey(blogId, "blog_id");

    public QBComments(String variable) {
        super(QBComments.class, forVariable(variable), "null", "b_comments");
        addMetadata();
    }

    public QBComments(String variable, String schema, String table) {
        super(QBComments.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBComments(String variable, String schema) {
        super(QBComments.class, forVariable(variable), schema, "b_comments");
        addMetadata();
    }

    public QBComments(Path<? extends QBComments> path) {
        super(path.getType(), path.getMetadata(), "null", "b_comments");
        addMetadata();
    }

    public QBComments(PathMetadata metadata) {
        super(QBComments.class, metadata, "null", "b_comments");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(blogId, ColumnMetadata.named("blog_id").withIndex(2).ofType(Types.VARCHAR).withSize(50));
        addMetadata(commentContext, ColumnMetadata.named("comment_context").withIndex(3).ofType(Types.VARCHAR).withSize(500));
        addMetadata(commentId, ColumnMetadata.named("comment_id").withIndex(1).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(email, ColumnMetadata.named("email").withIndex(5).ofType(Types.VARCHAR).withSize(100));
        addMetadata(likes, ColumnMetadata.named("likes").withIndex(7).ofType(Types.TINYINT).withSize(3));
        addMetadata(nikename, ColumnMetadata.named("nikename").withIndex(4).ofType(Types.VARCHAR).withSize(100));
        addMetadata(pCommentId, ColumnMetadata.named("p_comment_id").withIndex(10).ofType(Types.VARCHAR).withSize(50));
        addMetadata(publishDate, ColumnMetadata.named("publish_date").withIndex(6).ofType(Types.TIMESTAMP).withSize(19));
        addMetadata(topOrder, ColumnMetadata.named("top_order").withIndex(9).ofType(Types.INTEGER).withSize(10));
        addMetadata(trolling, ColumnMetadata.named("trolling").withIndex(8).ofType(Types.TINYINT).withSize(3));
    }

}

