package com.mateuserp.sistemagestaodeobras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mateuserp.sistemagestaodeobras.repository.UsuarioRepository;



@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
}
