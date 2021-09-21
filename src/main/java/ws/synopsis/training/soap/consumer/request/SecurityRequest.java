package ws.synopsis.training.soap.consumer.request;

import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class SecurityRequest extends UsernamePasswordAuthenticationToken {

    private LoginRequest request;

    public SecurityRequest(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, LoginRequest request)
    {
        super(principal, credentials, authorities);
        this.request = request;
    }

    public SecurityRequest(Object principal, Object credentials, LoginRequest request)
    {
        super(principal, credentials);
        this.request = request;
    }


}
