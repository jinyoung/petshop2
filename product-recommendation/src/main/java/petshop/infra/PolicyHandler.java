package petshop.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import petshop.config.kafka.KafkaProcessor;
import petshop.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    RecommendedProductRepository recommendedProductRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='밤12시'"
    )
    public void whenever밤12시_Recommend(@Payload 밤12시 밤12시) {
        밤12시 event = 밤12시;
        System.out.println("\n\n##### listener Recommend : " + 밤12시 + "\n\n");

        // Sample Logic //
        RecommendedProduct.recommend(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
