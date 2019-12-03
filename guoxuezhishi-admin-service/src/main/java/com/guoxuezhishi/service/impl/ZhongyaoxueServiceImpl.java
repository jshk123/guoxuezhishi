package com.guoxuezhishi.service.impl;

import com.guoxuezhishi.mapper.ZhongyaoxueMapper;
import com.guoxuezhishi.pojo.wechat.Zhongyaoxue;
import com.guoxuezhishi.service.ZhongyaoxueService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: jiang
 * @date: 2019/12/2
 */
@Service
public class ZhongyaoxueServiceImpl implements ZhongyaoxueService {

    public static Logger logger = Logger.getLogger(SpringBootApplication.class);

    @Autowired
    private ZhongyaoxueMapper zhongyaoxueMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveZhongyao(Zhongyaoxue zhongyaoxue) {
        zhongyaoxueMapper.insertSelective(zhongyaoxue);
    }

}
