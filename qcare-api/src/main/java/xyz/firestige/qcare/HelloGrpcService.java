package xyz.firestige.qcare;

import io.quarkus.grpc.GrpcService;
import xyz.firestige.qcare.HelloGrpc;
import xyz.firestige.qcare.HelloReply;
import xyz.firestige.qcare.HelloRequest;

import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloGrpcService implements HelloGrpc {

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom().item("Hello " + request.getName() + "!")
                .map(msg -> HelloReply.newBuilder().setMessage(msg).build());
    }

}
