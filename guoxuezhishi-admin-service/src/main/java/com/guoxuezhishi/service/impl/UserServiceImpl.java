package com.guoxuezhishi.service.impl;

import com.guoxuezhishi.mapper.UsersMapper;
import com.guoxuezhishi.pojo.wechat.Users;
import com.guoxuezhishi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean queryUserNameIsExist(String username) {
        Users user = new Users();
        user.setUsername(username);
        Users result = usersMapper.selectOne(user);
        return result == null ? false : true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(Users user) {
        long id = System.currentTimeMillis();
        String userId = Long.toString(id);
        user.setId(userId);
        usersMapper.insert(user);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Users queryUserForLogin(String username, String password) {
        Example userExample = new Example(Users.class);
        Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username", username);
        criteria.andEqualTo("password", password);
        Users result = usersMapper.selectOneByExample(userExample);
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserInfo(Users users) {
        Example userExample = new Example(Users.class);
        Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("id", users.getId());
        usersMapper.updateByExampleSelective(users, userExample);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Users queryUserInfo(String userId) {
        Example userExample = new Example(Users.class);
        Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("id", userId);
        Users users = usersMapper.selectOneByExample(userExample);
        return users;
    }
}















