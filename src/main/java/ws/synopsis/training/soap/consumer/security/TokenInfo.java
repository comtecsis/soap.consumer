package ws.synopsis.training.soap.consumer.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ws.synopsis.training.soap.consumer.model.Client;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

@Getter
@AllArgsConstructor
public class TokenInfo implements UserDetails, Serializable {

    private Long clientId;
    private String username;
    private RoleInfo role;

    public TokenInfo(Client client) {
        this.clientId = client.getClientId();
        this.username = client.getName();
        this.role = new RoleInfo(client.getRole());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(this.role);
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
