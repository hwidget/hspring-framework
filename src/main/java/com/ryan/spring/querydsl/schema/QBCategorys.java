package com.ryan.spring.querydsl.schema;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBCategorys is a Querydsl query type for QBCategorys
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QBCategorys extends com.querydsl.sql.RelationalPathBase<QBCategorys> {

    private static final long serialVersionUID = -1699178084;

    public static final QBCategorys bCategorys = new QBCategorys("b_categorys");

    public final NumberPath<Integer> categoryId = createNumber("categoryId", Integer.class);

    public final StringPath categoryName = createString("categoryName");

    public final NumberPath<Integer> categoryOrder = createNumber("categoryOrder", Integer.class);

    public final StringPath createdByUser = createString("createdByUser");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final com.querydsl.sql.PrimaryKey<QBCategorys> primary = createPrimaryKey(categoryId);

    public final com.querydsl.sql.ForeignKey<QBBlogs> _blogsCategorys = createInvForeignKey(categoryId, "category_id");

    public QBCategorys(String variable) {
        super(QBCategorys.class, forVariable(variable), "null", "b_categorys");
        addMetadata();
    }

    public QBCategorys(String variable, String schema, String table) {
        super(QBCategorys.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBCategorys(String variable, String schema) {
        super(QBCategorys.class, forVariable(variable), schema, "b_categorys");
        addMetadata();
    }

    public QBCategorys(Path<? extends QBCategorys> path) {
        super(path.getType(), path.getMetadata(), "null", "b_categorys");
        addMetadata();
    }

    public QBCategorys(PathMetadata metadata) {
        super(QBCategorys.class, metadata, "null", "b_categorys");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(categoryId, ColumnMetadata.named("category_id").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(categoryName, ColumnMetadata.named("category_name").withIndex(2).ofType(Types.VARCHAR).withSize(100));
        addMetadata(categoryOrder, ColumnMetadata.named("category_order").withIndex(3).ofType(Types.INTEGER).withSize(10));
        addMetadata(createdByUser, ColumnMetadata.named("created_by_user").withIndex(5).ofType(Types.VARCHAR).withSize(100));
        addMetadata(createdDate, ColumnMetadata.named("created_date").withIndex(4).ofType(Types.TIMESTAMP).withSize(19));
    }

}

