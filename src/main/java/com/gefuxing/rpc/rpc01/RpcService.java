package com.gefuxing.rpc.rpc01;

import com.gefuxing.rpc.model.User;
import com.gefuxing.rpc.service.Impl.UserServiceImpl;
import com.gefuxing.rpc.service.UserService;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author gefuxing
 * @create 2021/7/30 9:38
 */
@Log4j2
public class RpcService {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9999);
        while (true) {
            Socket accept = socket.accept();
            process(accept);
            accept.close();
        }
    }

    private static void process(Socket s) throws IOException {
        InputStream inputStream = s.getInputStream();
        OutputStream outputStream = s.getOutputStream();
        DataInputStream dis = new DataInputStream(inputStream);
        DataOutputStream dos = new DataOutputStream(outputStream);
        int id = dis.readInt();
        UserService userService = new UserServiceImpl();
        User user = userService.findUserById(id);
        dos.writeUTF(user.getName());
        dos.writeInt(user.getId());
        log.info(user.toString());
        dos.flush();
    }

}
