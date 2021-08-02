package com.gefuxing.rpc.rpc01;

import com.gefuxing.rpc.model.User;

import java.io.*;
import java.net.Socket;
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
            Socket s = new Socket("127.0.0.1", 9999);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(byteArrayOutputStream);
            dos.writeInt(id);
            s.getOutputStream().write(byteArrayOutputStream.toByteArray());
            s.getOutputStream().flush();


            InputStream inputStream = s.getInputStream();
            DataInputStream dis = new DataInputStream(inputStream);
//        int id = dis.readInt();
            String name = dis.readUTF();
            int userId = dis.readInt();
            User user = new User(userId, name);
            System.out.println(user.toString());
        }


    }
}
