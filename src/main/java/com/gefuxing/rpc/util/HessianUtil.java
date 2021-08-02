package com.gefuxing.rpc.util;

import com.caucho.hessian.io.Hessian2Input;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author gefuxing
 * @create 2021/8/2 13:53
 */
public class HessianUtil {
    public static byte[] serialize(Object o) throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(byteArrayOutputStream);
        output.writeObject(o);
        output.flush();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        output.close();
        return bytes;
    }
    public static Object deserialize(byte[] bytes) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteInputStream();
        Hessian2Input input = new Hessian2Input(byteArrayInputStream);
        Object o = input.readObject();
        byteArrayInputStream.close();
        input.close();
        return o;
    }

    public static byte[] serializeJdk(Object o) throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(byteArrayOutputStream);
        output.writeObject(o);
        output.flush();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        output.close();
        return bytes;
    }
}
