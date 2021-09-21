
package ws.synopsis.training.soap.consumer.response;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import ws.synopsis.training.soap.consumer.security.TokenInfo;

import java.util.Collection;

@Getter
public class SecurityToken extends UsernamePasswordAuthenticationToken
{

    private static final long serialVersionUID = -4943465268794839517L;

    private TokenInfo tokenInfo;

    public SecurityToken(Object principal, Object credentials, TokenInfo tokenInfo)
    {
        super(principal, credentials, tokenInfo.getAuthorities());
        this.tokenInfo = tokenInfo;
    }

}