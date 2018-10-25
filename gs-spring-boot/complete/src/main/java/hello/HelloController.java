package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/timeDelay")
    String processMessages(@RequestParam String timeDelay){
        KafkaProducer kafkaProducer = new KafkaProducer();
        kafkaProducer.setKafkaTemplate(kafkaTemplate);
        kafkaProducer.setSleepTime(Long.valueOf(timeDelay));
        Thread thread = new Thread(kafkaProducer);
        thread.start();
        return "Sending message with delay of : "+timeDelay +
                " ms to topic "+KafkaProducer.TOPIC_NAME;
    }

}
