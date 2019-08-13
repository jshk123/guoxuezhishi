package com.guoxuezhishi.mapper;

import com.guoxuezhishi.pojo.wechat.Users;
import com.guoxuezhishi.utils.MyMapper;
import org.springframework.stereotype.Component;

@Component(value = "Usersmapper")
public interface UsersMapper extends MyMapper<Users> {
    int deleteByPrimaryKey(String id);

    @Override
    int insertSelective(Users record);

    Users selectByPrimaryKey(String id);

    @Override
    int updateByPrimaryKeySelective(Users record);

    @Override
    int updateByPrimaryKey(Users record);
}