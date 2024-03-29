package br.com.securityoauth2.securityoauth2.security.cors;


import br.com.securityoauth2.securityoauth2.config.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Filtro para o CORS que sera necessári para permissão de Origin de requisição e Metodos
 *  link de exemplo  : https://www.youtube.com/watch?v=z_d0jxDq0Nw
 * @author dougl
 *
 */

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse)resp;


        response.setHeader("Access-Control-Allow-Origin", securityProperties.getOrigenPermitida());
        response.setHeader("Access-Control-Allow-Credentials", "true");

        if("OPTIONS".equals(request.getMethod()) && securityProperties.getOrigenPermitida().equals(request.getHeader("Origin"))){
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT,OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setStatus(HttpServletResponse.SC_OK);

        }else {
            chain.doFilter(req, resp);
        }

    }

}

