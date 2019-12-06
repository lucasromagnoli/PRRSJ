package br.com.lucasromagnoli.prbrsj.rest.controller;

import br.com.lucasromagnoli.prbrsj.domain.support.PrbrsjPropertiesSupport;
import br.com.lucasromagnoli.prbrsj.rest.constants.ControllerMapping;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    PrbrsjPropertiesSupport prbrsjPropertiesSupport;

    @DeleteMapping(ControllerMapping.PATH_AUTH_TOKEN_REVOKE)
    public void revoke(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        // TODO: riar uma classe SUPPORT para gerenciar os cookies
        Cookie cookie = new Cookie("refreshToken", null);
        cookie.setHttpOnly(true);
        cookie.setSecure((boolean) prbrsjPropertiesSupport.getProperty("cookie.https.secure", Boolean.class));
        cookie.setPath(httpServletRequest.getContextPath()+ControllerMapping.AUTH_TOKEN_GENERATE);
        cookie.setMaxAge(0);

        httpServletResponse.addCookie(cookie);
        httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
    }
}
