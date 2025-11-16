package io.project.app.producer;


import io.project.app.data.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class StreamProducer {

    private final StreamBridge streamBridge;

    @Scheduled(cron = "*/2 * * * * *")
    public void sendMessage() {
        streamBridge.send("producer-out-0", new Message(" Attack is Scheduled "));
    }
}
