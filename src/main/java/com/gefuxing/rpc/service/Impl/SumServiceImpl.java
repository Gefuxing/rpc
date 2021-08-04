package com.gefuxing.rpc.service.Impl;

import com.gefuxing.rpc.thrift.SumService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

/**
 * @Author gefuxing
 * @create 2021/8/2 17:21
 */
@Service
public class SumServiceImpl implements SumService.Iface {
    @Override
    public int getSum(int num1, int num2) throws TException {
        return (num1 + num2);
    }
}
