package com.gefuxing.rpc.rpc03;

import com.gefuxing.rpc.model.User;
import com.gefuxing.rpc.service.Impl.UserServiceImpl;
import com.gefuxing.rpc.service.UserService;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author gefuxing
 * @create 2021/7/30 9:38
 */
@Log4j2
public class RpcServiceRpc03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ServerSocket socket = new ServerSocket(9998);
        while (true) {
            Socket accept = socket.accept();
            process(accept);
            accept.close();
        }
    }

    private static void process(Socket s) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InputStream inputStream = s.getInputStream();
        OutputStream outputStream = s.getOutputStream();
        ObjectInputStream dis = new ObjectInputStream(inputStream);
        ObjectOutputStream dos = new ObjectOutputStream(outputStream);



        String name = dis.readUTF();
        Class<?>[] parameterTypes = (Class<?>[]) dis.readObject();
        Object[] args= (Object[]) dis.readObject();
        UserService userService = new UserServiceImpl();
        Method method = userService.getClass().getMethod(name, parameterTypes);
        User user = (User) method.invoke(userService,args);

        dos.writeObject(user);
        log.info(user.toString());
        dos.flush();
    }

}
