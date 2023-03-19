package com.shardingjdbc.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

@Slf4j
public class MyTablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<String>{

    /**
     * 自定义分表规则
     * @param availableTargetNames
     * @param preciseShardingValue
     * @return
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> preciseShardingValue) {
        //真实节点
        availableTargetNames.forEach(a -> log.info("actual node table:{}", a));

        log.info("logic table name:{}, route column:{}", preciseShardingValue.getLogicTableName(), preciseShardingValue.getColumnName());
        //精确分片
        log.info("column value:{}", preciseShardingValue.getValue());

        for (String availableTargetName : availableTargetNames) {
            if (("t_order"+preciseShardingValue.getValue()).equals(availableTargetName)) {
                return availableTargetName;
            }
        }
        return null;
    }
}
