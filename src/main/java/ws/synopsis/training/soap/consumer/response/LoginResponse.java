package ws.synopsis.training.soap.consumer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ws.synopsis.training.soap.consumer.security.TokenInfo;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String name;
    private String role;

    public LoginResponse(TokenInfo tokenInfo){
        this.name = tokenInfo.getUsername();
        this.role = tokenInfo.getRole().getAuthority();
    }

}
