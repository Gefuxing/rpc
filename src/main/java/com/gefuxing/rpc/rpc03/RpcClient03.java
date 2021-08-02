package com.gefuxing.rpc.rpc03;

import com.gefuxing.rpc.model.User;
import com.gefuxing.rpc.service.UserService;

import java.io.*;
import java.util.Scanner;

/**
 * @Author gefuxing
 * @create 2021/7/30 9:38
 */
public class RpcClient03 {
    public static void main(String[] args) throws IOException {
      while (true) {
            UserService userService = Stud03.getUserService();
            Scanner input=new Scanner(System.in);
            int id = input.nextInt();
            User user = userService.findUserById(id);

            System.out.println("rpc03:"+user);

    }
}
}