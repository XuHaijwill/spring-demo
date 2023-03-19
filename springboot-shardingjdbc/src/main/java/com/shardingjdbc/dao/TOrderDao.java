package com.shardingjdbc.dao;

import com.shardingjdbc.model.TOrder;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TOrderDao {

    void insert(TOrder tOrder);

    List<TOrder> getList();

    void delete(Integer id);

    int update(TOrder tOrder);
}
