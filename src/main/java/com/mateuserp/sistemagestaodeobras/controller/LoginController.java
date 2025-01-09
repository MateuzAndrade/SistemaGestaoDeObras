package com.mateuserp.sistemagestaodeobras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mateuserp.sistemagestaodeobras.model.Usuario;
import com.mateuserp.sistemagestaodeobras.repository.UsuarioRepository;

import jakarta.servlet.http.HttpServletResponse;



@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/logar")
    public String LoginUsuario(String usuario, String senha, Model model, HttpServletResponse response) {
        Usuario user = this.usuarioRepository.findByUsuarioAndSenha(usuario,senha);
        if(user != null ){
            return "home";
        }else{
            model.addAttribute("erro", "Usuário ou senha inválidos!");
            return "login";
        }
    }
    
    
}
