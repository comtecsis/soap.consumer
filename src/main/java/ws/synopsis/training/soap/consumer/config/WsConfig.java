package ws.synopsis.training.soap.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import pe.com.synopsis.client.soap.WsCountryClient;

@Component
public class WsConfig {

    @Bean
    public WsCountryClient wsCountryClient(WebServiceTemplate template, @Value("${country.ws.url}") String uri){
        return new WsCountryClient(template, uri, new SoapActionCallback(""));
    }

}
