package com.shardingjdbc.mapper;

import com.shardingjdbc.model.TOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TOrderMapper {
    void insert(TOrder tOrder);

    List<TOrder> getList();

    void delete(Integer id);

    int update(TOrder tOrder);
}