package br.com.alura.forum.config.security;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class TokenService {


    private static final String ISSUER = "com.github.throyer.forum.api";

    public String gerarToken(Authentication authentication) {

        String USUARIO = usuarioToString(authentication);
        Date HOJE = new Date();

        return Jwts.builder()
                .setIssuer(ISSUER)
                .setSubject(USUARIO)
                .setIssuedAt(HOJE)
                .setExpiration(getExpirationDate())
                .signWith(SignatureAlgorithm.HS256,"teste")
                .compact();
    }


    private Date getExpirationDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    private String usuarioToString(Authentication authentication) {
        Usuario UsuarioLogado = (Usuario) authentication.getPrincipal();
        return UsuarioLogado.getId().toString();
    }
}
