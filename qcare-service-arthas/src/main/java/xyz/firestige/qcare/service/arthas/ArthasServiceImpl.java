package xyz.firestige.qcare.service.arthas;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;

import jakarta.inject.Inject;
import xyz.firestige.qcare.service.ArthasCommand;
import xyz.firestige.qcare.service.ArthasGrpc;
import xyz.firestige.qcare.service.ArthasJobResult;

@GrpcService
public class ArthasServiceImpl implements ArthasGrpc {

    @Inject
    Vertx vertx;

    @Override
    public Uni<ArthasJobResult> execute(ArthasCommand request) {
        WebClient client = WebClient.create(vertx);

        return client.getAbs(request.getCommand()) // 假设使用 getCommand() 作为 URL
                .send()
                .onItem().transform(response ->
                        ArthasJobResult.newBuilder()
                                .setJobId(response.bodyAsString()) // 根据实际的 proto 字段调整
                                .build()
                )
                .onFailure().recoverWithItem(
                        ArthasJobResult.newBuilder()
                                .setJobId("Error occurred")
                                .build()
                );
    }
}

