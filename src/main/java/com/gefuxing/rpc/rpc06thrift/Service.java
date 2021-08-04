package com.gefuxing.rpc.rpc06thrift;

import com.gefuxing.rpc.service.Impl.SumServiceImpl;
import com.gefuxing.rpc.thrift.SumService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @Author gefuxing
 * @create 2021/8/2 17:26
 */
public class Service {
    public static final int PORT = 8090;

    public static void main(String[] args) throws TTransportException {
        System.out.println("服务端开启");
        TProcessor tProcessor = new SumService.Processor<SumService.Iface>(new SumServiceImpl());
        TServerSocket tServerSocket = new TServerSocket(PORT);
        TServer.Args tArgs = new TServer.Args(tServerSocket);
        tArgs.processor(tProcessor);
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
        TServer tServer = new TSimpleServer(tArgs);
        tServer.serve();
    }
}
