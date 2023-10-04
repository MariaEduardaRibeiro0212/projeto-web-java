package com.senai.primeiraaplicacaoweb.controller;

import com.senai.primeiraaplicacaoweb.model.UserModel;
import com.senai.primeiraaplicacaoweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/formulario")
    public String registerUsers(){
        return "users/register";
    }

    @PostMapping(value = "/cadastrar")
    public String saveUser(UserModel userModel){
        userService.save(userModel);
        return "redirect:/usuarios/listar";
    }

    @GetMapping(value = "/listar")
    public String listAllUsers(Model model){
        List<UserModel> listUser = userService.findAll();
        model.addAttribute("users", listUser);

        return "users/list";
    }
    @GetMapping(value = "/{id}")
    public String getUserById(@PathVariable Long id, Model model){
        Optional<UserModel> user = userService.findById(id);

        if(user.isPresent()){
            model.addAttribute("user", user.get());
            return "users/update";
        }else{
            return "redirect:/usuarios/listar";
        }
    }
    @PostMapping (value = "/alterar/{id}")
    public String updateUser(@PathVariable Long id, UserModel userModel){
       Optional<UserModel> user = userService.findById(id);

       if(user.isPresent()){
           userService.save(userModel);
           return "redirect:/usuarios/listar";
       }else{
           return "redirect: /usuarios/listar/";
       }
    }

    @GetMapping(value = "delete/{id}")
    public String deleteUserById(@PathVariable Long id){
        userService.deleteById(id);
        return "redirect:/usuarios/listar";
    }
}
