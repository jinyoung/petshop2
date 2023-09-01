package petshop.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import petshop.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import petshop.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler{
    @Autowired RecommendedProductRepository recommendedProductRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='12OClockAtNight'")
    public void whenever12OClockAtNight_Recommend(@Payload 12OClockAtNight 12OClockAtNight){

        12OClockAtNight event = 12OClockAtNight;
        System.out.println("\n\n##### listener Recommend : " + 12OClockAtNight + "\n\n");


        

        // Sample Logic //
        RecommendedProduct.recommend(event);
        

        

    }

}

//>>> Clean Arch / Inbound Adaptor

