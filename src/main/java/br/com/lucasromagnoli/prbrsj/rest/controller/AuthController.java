package br.com.lucasromagnoli.prbrsj.rest.controller;

import br.com.lucasromagnoli.prbrsj.rest.constants.ControllerMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(ControllerMapping.PATH_ROOT_AUTH_TOKEN)
public class AuthController {

    @DeleteMapping(ControllerMapping.PATH_AUTH_TOKEN_REVOKE)
    public void revoke(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie("refreshToken", null);
        cookie.setHttpOnly(true);
        cookie.setSecure(false); // TODO: Mudar conforme variavel de ambiente + Criar uma classe SUPPORT para gerenciar os cookies
        cookie.setPath(httpServletRequest.getContextPath()+ControllerMapping.AUTH_TOKEN_GENERATE);
        cookie.setMaxAge(0);

        httpServletResponse.addCookie(cookie);
        httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
    }
}
