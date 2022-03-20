package org.example.cache.service;

import org.example.cache.dao.CitiesDao;
import org.example.cache.entity.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("citiesService")
public class CitiesServiceImpl implements CitiesService{
    @Autowired
    private CitiesDao citiesDao;

    public int update(final Cities entity){
        return citiesDao.updateByEntity(entity);
    }

    public int add(final Cities entity){
        return citiesDao.insert(entity);
    }

    @Cacheable(value = "city")
    public List<Cities> list(String provinceid){
        return citiesDao.list(provinceid);
    }



}