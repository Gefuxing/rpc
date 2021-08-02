package com.gefuxing.rpc.service.Impl;

import com.gefuxing.rpc.model.School;
import com.gefuxing.rpc.service.SchoolService;
import org.springframework.stereotype.Service;

/**
 * @Author gefuxing
 * @create 2021/8/2 10:40
 */
@Service
public class SchoolServiceImpl implements SchoolService {
    @Override
    public School findBySchool(Integer id) {
        return new School(id,"哈工大");
    }
}
