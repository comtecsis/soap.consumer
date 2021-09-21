package ws.synopsis.training.soap.consumer.security;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ws.synopsis.training.soap.consumer.exception.TrainingAuthException;
import ws.synopsis.training.soap.consumer.request.SecurityRequest;
import ws.synopsis.training.soap.consumer.response.SecurityToken;
import ws.synopsis.training.soap.consumer.service.LoginService;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private LoginService loginService;

    public CustomAuthenticationProvider(LoginService loginService) {
        super();
        this.loginService = loginService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SecurityRequest loginRequest = (SecurityRequest) authentication;
        TokenInfo tokenInfo = this.loginService.login(loginRequest.getRequest());
        final Authentication auth = new SecurityToken(loginRequest.getRequest().getNumberDocument(), "", tokenInfo);
        // Guardar en base el token e inhabilitar los anteriores asociados al numero de documento.
        return auth;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
