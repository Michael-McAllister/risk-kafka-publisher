package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

/**
 * Created by michael on 25/10/2018.
 */
public class RiskMessageTest {

    private static ObjectMapper objectMapper = new ObjectMapper()
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    @Test
    public void testRiskMessageJson() throws JsonProcessingException {
        objectMapper.setDateFormat(
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
        System.out.println(objectMapper.writeValueAsString(
                RiskMessage.RANDOM_RISK_NOTIFICATION("2018-07-01", "eod")
        ));
    }
}