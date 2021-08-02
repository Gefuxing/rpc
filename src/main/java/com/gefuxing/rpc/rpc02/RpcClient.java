package com.gefuxing.rpc.rpc02;

import com.gefuxing.rpc.model.User;

import java.io.*;
import java.util.Scanner;

/**
 * @Author gefuxing
 * @create 2021/7/30 9:38
 */
public class RpcClient {
    public static void main(String[] args) throws IOException {
        while (true) {
            Scanner input=new Scanner(System.in);
            int id = input.nextInt();
            User user = Stub.getUserService(id);
            System.out.println("rpc02:"+user);
        }


    }
}
