package com.shardingjdbc.dao.impl;

import com.shardingjdbc.dao.TOrderDao;
import com.shardingjdbc.mapper.TOrderMapper;
import com.shardingjdbc.model.TOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TOrderDaoImpl implements TOrderDao {

    @Autowired
    private TOrderMapper tOrderMapper;

    @Override
    public void insert(TOrder tOrder) {
        tOrderMapper.insert(tOrder);
    }

    @Override
    public List<TOrder> getList() {
        return tOrderMapper.getList();
    }

    @Override
    public void delete(Integer id) {
        tOrderMapper.delete(id);

    }

    @Override
    public int update(TOrder tOrder) {
        return tOrderMapper.update(tOrder);
    }
}
