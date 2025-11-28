package art.cookedincode.spring6coolservice.listeners;

import art.cookedincode.spring6coolservice.config.KafkaConfig;
import art.cookedincode.spring6restmvcapi.events.DrinkPreparedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Georgi Ivanov.
 */
@Component
public class DrinkPreparedListener {

    AtomicInteger coolMessageCounter = new AtomicInteger(0);

    @KafkaListener(topics = KafkaConfig.DRINK_PREPARED_TOPIC, groupId = "cool-listener")
    public void listen(DrinkPreparedEvent event) {
        System.out.println("I'm listening...");
        coolMessageCounter.incrementAndGet();
    }
}
