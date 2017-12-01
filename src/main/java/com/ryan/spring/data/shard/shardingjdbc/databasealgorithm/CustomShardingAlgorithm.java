package com.ryan.spring.data.shard.shardingjdbc.databasealgorithm;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/11/4
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class CustomShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<String> {

    private static final Logger LOG = LoggerFactory.getLogger(CustomShardingAlgorithm.class);

    /**
     * Sharding with between operator.
     *
     * @param availableTargetNames available data sources or tables's names
     * @param shardingValue        sharding value
     * @return sharding results for data sources or tables's names
     */
    @Override
    public Collection<String> doBetweenSharding(Collection<String> availableTargetNames, ShardingValue<String> shardingValue) {
        return null;
    }

    /**
     * Sharding with equal operator.
     *
     * @param availableTargetNames available data sources or tables's names
     * @param shardingValue        sharding value
     * @return sharding results for data sources or tables's names
     */
    @Override
    public String doEqualSharding(Collection<String> availableTargetNames, ShardingValue<String> shardingValue) {
        return null;
    }

    /**
     * Sharding with in operator.
     *
     * @param availableTargetNames available data sources or tables's names
     * @param shardingValue        sharding value
     * @return sharding results for data sources or tables's names
     */
    @Override
    public Collection<String> doInSharding(Collection<String> availableTargetNames, ShardingValue<String> shardingValue) {
        return null;
    }
}
