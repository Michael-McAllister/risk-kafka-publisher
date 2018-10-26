package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by michael on 25/10/2018.
 */
public class KafkaProducer implements Runnable{

    public static final String TOPIC_NAME = "test";

    private long sleepTime = 5;

    private static ObjectMapper objectMapper = new ObjectMapper()
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    public void setSleepTime(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(sleepTime);
              //  sendMessage(objectMapper.writeValueAsString(RiskMessage.RANDOM_RISK_NOTIFICATION()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


