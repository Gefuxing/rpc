package com.gefuxing.rpc.service;

import com.gefuxing.rpc.model.School;

/**
 * @Author gefuxing
 * @create 2021/8/2 10:40
 */
public interface SchoolService {
    School findBySchool(Integer id);
}
