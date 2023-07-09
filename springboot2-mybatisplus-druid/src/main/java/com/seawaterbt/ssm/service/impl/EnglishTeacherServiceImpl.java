package com.seawaterbt.ssm.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seawaterbt.ssm.entity.EnglishTeacher;
import com.seawaterbt.ssm.mapper.EnglishTeacherMapper;
import com.seawaterbt.ssm.service.EnglishTeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class EnglishTeacherServiceImpl extends ServiceImpl<EnglishTeacherMapper, EnglishTeacher> implements EnglishTeacherService {
    public static final Logger log = LoggerFactory.getLogger(EnglishTeacherServiceImpl.class);

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(EnglishTeacher entity) {
//        return saveEntity(entity);

        log.info("进入事务");
        int count = baseMapper.insert(entity);
        log.info("count={}", count);
//        int i = 1/0;
        return retBool(count);
    }


    @Override
    public boolean removeById(Serializable id) {
        return retBool(baseMapper.deleteById(id));
    }

    public boolean retBool(Integer result) {
        return null != result && result >= 1;
    }

    @Override
    public boolean updateById(EnglishTeacher entity) {
        return retBool(baseMapper.updateById(entity));
    }

    @Override
    public List<EnglishTeacher> list(Wrapper<EnglishTeacher> wrapper) {
        return baseMapper.selectList(wrapper);
    }

}
