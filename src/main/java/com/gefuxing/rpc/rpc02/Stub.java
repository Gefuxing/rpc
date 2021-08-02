package com.gefuxing.rpc.rpc02;

import com.gefuxing.rpc.model.User;
import com.gefuxing.rpc.service.UserService;

import java.io.*;
import java.net.Socket;

/**
 * @Author gefuxing
 * @create 2021/7/30 12:26
 */
public class Stub {
    public static User getUserService(Integer id) throws IOException {

        Socket s = new Socket("127.0.0.1", 9999);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(byteArrayOutputStream);
        dos.writeInt(id);
        s.getOutputStream().write(byteArrayOutputStream.toByteArray());
        s.getOutputStream().flush();


        InputStream inputStream = s.getInputStream();
        DataInputStream dis = new DataInputStream(inputStream);
        String name = dis.readUTF();
        int userId = dis.readInt();
        User user = new User(userId, name);
        return user;
    }
}
