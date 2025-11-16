package io.project.app.repository;

import io.project.app.model.Message;
import io.project.app.utils.MessageGenerator;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Repository
public class ReactiveMessageRepository implements MessageRepository {

    /**
     * Retrieves a Flux of Message objects at intervals of 3 seconds. Emits
     * elements on a regular interval, handles backpressure by dropping excess
     * elements, and transforms each interval into a Flux of Message objects.
     *
     * @return Flux<Message> representing a stream of Message objects
     */
    @Override
    public Flux<Message> findAll() {
        return Flux.interval(Duration.ofSeconds(3)) // Emit elements every 3 seconds
                .onBackpressureDrop() // Handle backpressure by dropping excess elements
                .flatMap(interval -> Flux.fromIterable(getNewPortionOfData(interval)));  // Transform interval into a Flux of Message objects
    }

    /**
     * Generates a new portion of data (in this case, a single Message object)
     * based on the given interval.
     *
     * @param interval the interval value emitted by Flux.interval
     * @return List<Message> containing a new Message object
     */
    private List<Message> getNewPortionOfData(long interval) {
        Message message = new Message(
                MessageGenerator.randomAuthor(), // Generate a random author name
                MessageGenerator.randomMessage(), // Generate a random message content
                MessageGenerator.getCurrentTimeStamp() // Get the current timestamp
        );
        return Arrays.asList(message);  // Return the Message object as a List
    }
}
