package xyz.firestige.qcare.api;

import io.quarkus.grpc.GrpcClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import xyz.firestige.qcare.service.ArthasCommand;
import xyz.firestige.qcare.service.ArthasGrpc;

@Path("/api/v1/arthas")
public class ArthasResource {

    @GrpcClient
    ArthasGrpc arthasClient;


    @GET
    @Produces("application/json")
    @Path("/{agentId}")
    public String connect() {
        ArthasCommand.newBuilder().setName()
        arthasClient.execute(ArthasCommand.newBuilder().setCommand("http://example.com").build())
                .subscribe().with(
                        result -> {
                            System.out.println("Arthas Job ID: " + result.getJobId());
                        },
                        failure -> {
                            System.err.println("Failed to execute Arthas command: " + failure.getMessage());
                        }
                );
        return "Arthas API is up and running!";
    }
}
