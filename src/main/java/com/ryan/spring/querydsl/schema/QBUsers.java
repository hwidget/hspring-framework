package com.ryan.spring.querydsl.schema;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBUsers is a Querydsl query type for QBUsers
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QBUsers extends com.querydsl.sql.RelationalPathBase<QBUsers> {

    private static final long serialVersionUID = -1145335825;

    public static final QBUsers bUsers = new QBUsers("b_users");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath contacts = createString("contacts");

    public final StringPath createdByUser = createString("createdByUser");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath email = createString("email");

    public final NumberPath<Byte> isDisable = createNumber("isDisable", Byte.class);

    public final StringPath loginname = createString("loginname");

    public final StringPath loginpass = createString("loginpass");

    public final StringPath nikename = createString("nikename");

    public final NumberPath<Integer> userId = createNumber("userId", Integer.class);

    public final com.querydsl.sql.PrimaryKey<QBUsers> primary = createPrimaryKey(userId);

    public QBUsers(String variable) {
        super(QBUsers.class, forVariable(variable), "null", "b_users");
        addMetadata();
    }

    public QBUsers(String variable, String schema, String table) {
        super(QBUsers.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBUsers(String variable, String schema) {
        super(QBUsers.class, forVariable(variable), schema, "b_users");
        addMetadata();
    }

    public QBUsers(Path<? extends QBUsers> path) {
        super(path.getType(), path.getMetadata(), "null", "b_users");
        addMetadata();
    }

    public QBUsers(PathMetadata metadata) {
        super(QBUsers.class, metadata, "null", "b_users");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(age, ColumnMetadata.named("age").withIndex(6).ofType(Types.INTEGER).withSize(10));
        addMetadata(contacts, ColumnMetadata.named("contacts").withIndex(7).ofType(Types.VARCHAR).withSize(100));
        addMetadata(createdByUser, ColumnMetadata.named("created_by_user").withIndex(10).ofType(Types.VARCHAR).withSize(255));
        addMetadata(createdDate, ColumnMetadata.named("created_date").withIndex(9).ofType(Types.TIMESTAMP).withSize(19));
        addMetadata(email, ColumnMetadata.named("email").withIndex(5).ofType(Types.VARCHAR).withSize(100));
        addMetadata(isDisable, ColumnMetadata.named("is_disable").withIndex(8).ofType(Types.TINYINT).withSize(3));
        addMetadata(loginname, ColumnMetadata.named("loginname").withIndex(3).ofType(Types.VARCHAR).withSize(100));
        addMetadata(loginpass, ColumnMetadata.named("loginpass").withIndex(4).ofType(Types.VARCHAR).withSize(100));
        addMetadata(nikename, ColumnMetadata.named("nikename").withIndex(2).ofType(Types.VARCHAR).withSize(100));
        addMetadata(userId, ColumnMetadata.named("user_id").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

