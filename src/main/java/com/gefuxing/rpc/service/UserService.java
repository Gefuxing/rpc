package com.gefuxing.rpc.service;

import com.gefuxing.rpc.model.User;

/**
 * @Author gefuxing
 * @create 2021/7/30 9:45
 */
public interface UserService {
    User findUserById(Integer id);
}
