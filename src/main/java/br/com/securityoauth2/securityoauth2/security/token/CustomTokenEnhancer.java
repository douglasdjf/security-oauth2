package br.com.securityoauth2.securityoauth2.security.token;

import br.com.securityoauth2.securityoauth2.security.model.UsuarioSistema;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        UsuarioSistema usuarioSistema = (UsuarioSistema) authentication.getPrincipal();

        Map<String,Object> addInfo = new HashMap<>();



        addInfo.put("nome", usuarioSistema.getUsuario().getNome());
        addInfo.put("permissoes", usuarioSistema.getPermissoes().toArray());
        addInfo.put("email", usuarioSistema.getUsuario().getEmail());
        addInfo.put("data_expiracao",((DefaultOAuth2AccessToken) accessToken).getExpiration());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);

        return accessToken;
    }
}
