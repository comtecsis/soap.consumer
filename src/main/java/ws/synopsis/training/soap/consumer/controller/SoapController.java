package ws.synopsis.training.soap.consumer.controller;

import io.spring.guides.gs_producing_web_service.Country;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.com.synopsis.client.soap.WsCountryClient;
import ws.synopsis.training.soap.consumer.enumeration.TrainingStatusEnum;
import ws.synopsis.training.soap.consumer.request.CountryRequest;
import ws.synopsis.training.soap.consumer.response.SecurityToken;
import ws.synopsis.training.soap.consumer.response.TrainingResponse;

@RestController
@AllArgsConstructor
public class SoapController {

    private final WsCountryClient client;

    @GetMapping
    public ResponseEntity<TrainingResponse<Country>> findByName(@AuthenticationPrincipal SecurityToken token, CountryRequest beanRequest) {

        System.out.println(String.format("El usuario %s invoco al servicio soap.", token.getTokenInfo().getClientId()));

        TrainingResponse<Country> response = new TrainingResponse<>();
        response.setStatus(TrainingStatusEnum.OK.getStatus());
        response.setData(client.getCountry(beanRequest.getName()).getCountry());
        return ResponseEntity.ok(response);
    }

}
