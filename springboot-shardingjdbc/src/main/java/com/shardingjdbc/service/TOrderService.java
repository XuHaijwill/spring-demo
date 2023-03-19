package com.shardingjdbc.service;

import com.shardingjdbc.dao.TOrderDao;
import com.shardingjdbc.model.TOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TOrderService {
    @Resource
    private TOrderDao tOrderDao;


    public void save(TOrder tOrder) {
        tOrderDao.insert(tOrder);
    }

    public void delete(Integer id) {
        tOrderDao.delete(id);
    }

    public int update(TOrder tOrder) {
        return tOrderDao.update(tOrder);
    }

    public List<TOrder> getList() {
        return tOrderDao.getList();
    }
}
