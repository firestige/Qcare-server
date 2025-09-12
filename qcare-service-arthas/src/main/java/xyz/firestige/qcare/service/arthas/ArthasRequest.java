package xyz.firestige.qcare.service.arthas;

public record ArthasRequest(
        Action action,
        String requestId,
        String sessionId,
        String consumerId,
        String command,
        int timeout
) {
}
