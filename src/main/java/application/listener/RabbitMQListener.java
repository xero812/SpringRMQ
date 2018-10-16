package application.listener;

import application.data.Data;
import application.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@Component
public class RabbitMQListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQListener.class);

    @Override
    public void onMessage(Message message) {
        try {
            application.entity.Message messageReceived = (application.entity.Message)
                    (new ObjectInputStream(new ByteArrayInputStream(message.getBody())).readObject());
            LOGGER.info("Received Message :" + messageReceived);
            Data.messages.add(messageReceived);
        } catch (IOException e) {
            LOGGER.error("I/O Error caught:" + e.getMessage());
        } catch (ClassNotFoundException e) {
            LOGGER.error("Class not found Exception:" + e.getMessage());
        }
    }

}
