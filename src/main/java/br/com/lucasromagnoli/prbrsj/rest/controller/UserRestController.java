package br.com.lucasromagnoli.prbrsj.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserRestController {

    @GetMapping()
    public ResponseEntity index() {
        return ResponseEntity.ok("Ygu nera gay, nera ?");
    }

}
