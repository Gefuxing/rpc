package com.gefuxing.rpc.rpc04;

import com.gefuxing.rpc.service.Impl.SchoolServiceImpl;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;


@Log4j2
public class RpcServiceRpc04 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ServerSocket socket = new ServerSocket(9998);
        while (true) {
            Socket accept = socket.accept();
            process(accept);
            accept.close();
        }
    }

    private static void process(Socket s) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        InputStream inputStream = s.getInputStream();
        OutputStream outputStream = s.getOutputStream();
        ObjectInputStream dis = new ObjectInputStream(inputStream);
        ObjectOutputStream dos = new ObjectOutputStream(outputStream);


        String className = dis.readUTF();
        String name = dis.readUTF();
        Class<?>[] parameterTypes = (Class<?>[]) dis.readObject();
        Object[] args= (Object[]) dis.readObject();

        Class clazz = null;

        clazz= SchoolServiceImpl.class;


        Method method = clazz.getMethod(name, parameterTypes);
        Object invoke = method.invoke(clazz.newInstance(), args);

        dos.writeObject(invoke);
        log.info(invoke.toString());
        dos.flush();
    }


}
