package com.nullsafety.webapp;

import io.grpc.stub.StreamObserver;
import com.nullsafety.general.lib.HelloReply;
import com.nullsafety.general.lib.HelloRequest;
import com.nullsafety.general.lib.SimpleGrpc;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello ==> " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}