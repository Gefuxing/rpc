package com.gefuxing.rpc.service.Impl;

import com.gefuxing.rpc.model.User;
import com.gefuxing.rpc.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @Author gefuxing
 * @create 2021/7/30 9:47
 */
@Service
@Log4j2
public class UserServiceImpl implements UserService {


    @Override
    public User findUserById(Integer id) {
        return new User(id,"gfx");
    }
}
