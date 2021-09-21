package ws.synopsis.training.soap.consumer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private String numberDocument;
    private String word;
    private String version;
}
