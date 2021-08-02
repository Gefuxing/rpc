package com.gefuxing.rpc.rpc03;

import com.gefuxing.rpc.model.User;
import com.gefuxing.rpc.service.UserService;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @Author gefuxing
 * @create 2021/7/30 13:40
 */
public class Stud03 {
    public static UserService getUserService() {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1", 9998);

                ObjectOutputStream dos = new ObjectOutputStream(s.getOutputStream());

                String name1 = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                dos.writeUTF(name1);
                dos.writeObject(parameterTypes);
                dos.writeObject(args);
                dos.flush();


                InputStream inputStream = s.getInputStream();
                ObjectInputStream dis = new ObjectInputStream(inputStream);
                User user = (User) dis.readObject();
                return user;
            }
        };
        Object o = Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, handler);
        return (UserService) o;
    }
}
