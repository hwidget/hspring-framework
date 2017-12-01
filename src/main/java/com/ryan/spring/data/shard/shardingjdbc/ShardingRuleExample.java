package com.ryan.spring.data.shard.shardingjdbc;

import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.NoneDatabaseShardingAlgorithm;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.NoneTableShardingAlgorithm;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.constant.DatabaseType;
import com.dangdang.ddframe.rdb.sharding.parsing.SQLParsingEngine;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.context.condition.Conditions;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.sql.SQLStatement;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/11/4
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class ShardingRuleExample extends AbstractShardingRule {

    private static final Logger LOG = LoggerFactory.getLogger(ShardingRuleExample.class);


    /**
     * SQL 解析引擎
     */
    public void sqlParsingEngine() {

        TableRule tableRule = TableRule.builder("test").dynamic(true).build();

        ShardingRule shardingRule = ShardingRule.builder().tableRules(Lists.<TableRule>newArrayList(tableRule)).build();

        SQLParsingEngine sqlParsingEngine = new SQLParsingEngine(DatabaseType.MySQL, "select aa, bb, cc from test", shardingRule);
        SQLStatement sqlStatement = sqlParsingEngine.parse();

        Conditions conditions = sqlStatement.getConditions();
        LOG.info("conditions : {}", conditions);
        LOG.info("table : {}", sqlStatement.getTables());
        LOG.info("sqlTokens : {}", sqlStatement.getSqlTokens());

    }


    public void demo1() {


        HashMap<String, DataSource> sourceHashMap = new HashMap<>();
        DataSourceRule dataSourceRule = new DataSourceRule(sourceHashMap);


        TableRule tableRule = TableRule.builder("test").dynamic(true).build();

        ArrayList<TableRule> tableRuleList = Lists.newArrayList();
        tableRuleList.add(tableRule);


        NoneDatabaseShardingAlgorithm noneDatabaseShardingAlgorithm = new NoneDatabaseShardingAlgorithm();

        NoneTableShardingAlgorithm noneTableShardingAlgorithm = new NoneTableShardingAlgorithm();

        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(dataSourceRule)
                .tableRules(tableRuleList)
                .databaseShardingStrategy(new DatabaseShardingStrategy("sharding_column", noneDatabaseShardingAlgorithm))
                .tableShardingStrategy(new TableShardingStrategy("sharding_column", noneTableShardingAlgorithm))
                .build();


    }

    /**
     * 执行
     */
    @Override
    public void run() {
        /**
         *
         */
        sqlParsingEngine();
    }


    public static void main(String[] args) {
        ShardingRuleExample shardingRuleExample = new ShardingRuleExample();

        shardingRuleExample.run();
    }
}
