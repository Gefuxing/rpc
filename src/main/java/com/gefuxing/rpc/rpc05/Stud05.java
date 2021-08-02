package com.gefuxing.rpc.rpc05;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;


public class Stud05 {
    public static Object getStud(Class clazz) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1", 9998);

                ObjectOutputStream dos = new ObjectOutputStream(s.getOutputStream());

                String className = clazz.getName();
                String name1 = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                dos.writeUTF(className);
                dos.writeUTF(name1);
                dos.writeObject(parameterTypes);
                dos.writeObject(args);
                dos.flush();


                InputStream inputStream = s.getInputStream();
                ObjectInputStream dis = new ObjectInputStream(inputStream);
                Object o = dis.readObject();
                return o;
            }
        };
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, handler);
        return o;
    }
}
