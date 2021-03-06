package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by michael on 25/10/2018.
 */
public class RunnableProducer {

    private static ObjectMapper objectMapper = new ObjectMapper()
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.154.0.10:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "testproducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class.getName());

        org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
        for(int i=0;i<Integer.parseInt(args[0]);i++) {
            try {
                RecordMetadata result = producer.send(new ProducerRecord<String, String>(
                        KafkaProducer.TOPIC_NAME, objectMapper.writeValueAsString(
                        RiskMessage.RANDOM_RISK_NOTIFICATION(args[1], args[2]))))
                        .get(60, TimeUnit.SECONDS);
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(args[0]+" messages published ");
    }

}
