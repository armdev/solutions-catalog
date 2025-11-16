package io.project.app.controller;

import io.project.app.model.Message;
import lombok.extern.slf4j.Slf4j;
import io.project.app.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@Slf4j
public class MessageController {

    @Autowired
    private MessageRepository commentRepository;

    /**
     * Endpoint to stream feeds.
     * Uses TEXT_EVENT_STREAM_VALUE to stream data as Server-Sent Events (SSE).
     * Delays each emitted element by 3 seconds, caches results for efficient repeated access,
     * limits the stream to 50 elements, handles backpressure by dropping excess elements,
     * and repeats the entire stream 3 times.
     *
     * @return Flux<Message> representing a stream of comments
     */
    @GetMapping(path = "/feed/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> feed() {
        // Retrieve comments from repository as a Flux
        Flux<Message> commentFlux = this.commentRepository.findAll();

        // Delay each emitted comment by 3 seconds
        commentFlux = commentFlux.delayElements(Duration.ofSeconds(3));

        // Cache results for efficient repeated access within this Flux pipeline
        commentFlux = commentFlux.cache();

        // Limit the stream to 50 feeds
        commentFlux = commentFlux.take(50);

        // Handle backpressure by dropping excess elements
        commentFlux = commentFlux.onBackpressureDrop();

        // Repeat the entire stream 3 times
        commentFlux = commentFlux.repeat(3);

        return commentFlux;
    }

}

