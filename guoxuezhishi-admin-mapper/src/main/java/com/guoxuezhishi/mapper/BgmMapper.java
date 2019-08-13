package com.guoxuezhishi.mapper;

import com.guoxuezhishi.pojo.wechat.Bgm;
import com.guoxuezhishi.utils.MyMapper;
import org.springframework.stereotype.Component;

@Component(value = "BgmMapper")
public interface BgmMapper extends MyMapper<Bgm> {
    int deleteByPrimaryKey(String id);

    int insert(Bgm record);

    int insertSelective(Bgm record);

    Bgm selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Bgm record);

    int updateByPrimaryKey(Bgm record);
}