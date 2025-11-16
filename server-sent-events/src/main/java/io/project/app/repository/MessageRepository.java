package io.project.app.repository;

import io.project.app.model.Message;
import reactor.core.publisher.Flux;

public interface MessageRepository {

    Flux<Message> findAll();

}
