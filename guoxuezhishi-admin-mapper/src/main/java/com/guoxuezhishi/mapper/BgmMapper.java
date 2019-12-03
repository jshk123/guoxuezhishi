package com.guoxuezhishi.mapper;

import com.guoxuezhishi.pojo.wechat.Bgm;
import com.guoxuezhishi.utils.MyMapper;
import org.springframework.stereotype.Component;

@Component(value = "BgmMapper")
public interface BgmMapper extends MyMapper<Bgm> {
    int deleteByPrimaryKey(String id);

    @Override
    int insert(Bgm record);

    @Override
    int insertSelective(Bgm record);

    Bgm selectByPrimaryKey(String id);

    @Override
    int updateByPrimaryKeySelective(Bgm record);

    @Override
    int updateByPrimaryKey(Bgm record);
}