package com.gefuxing.rpc.rpc05;

import com.gefuxing.rpc.model.User;
import com.gefuxing.rpc.util.HessianUtil;


import java.io.IOException;

/**
 * @Author gefuxing
 * @create 2021/8/2 14:04
 */
public class client {
    public static void main(String[] args) throws IOException {
        User user = new User(1, "gfxttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
        byte[] serialize = HessianUtil.serialize(user);
        System.out.println(serialize.length);
        System.out.println(HessianUtil.serializeJdk(user).length);
    }
}
