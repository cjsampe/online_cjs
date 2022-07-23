package com.online.online.controller;


import com.online.online.domain.User;
import com.online.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /** dar de alta un nuevo ususario rellenando el formulario**/
    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user, Model model ){
        /**Dar de alta el usuario rellenado por el ususario **/
        userService.addUser(user);
        model.addAttribute("message", "Usuario registrado correctamente");
        return "register-user";
    }


    /** entrada de usuario ya registrado **/
    @GetMapping("/register-user")
    public String registerUser(Model model) {
        /**al modelo le creo un atributo, un usuario vacio que seguir**/
        model.addAttribute("user", new User());
        return "register-user";
    }

    @GetMapping("/user/{userId}")
    public String getUserProfile(Model model, @PathVariable long userId){
        // TODO Buscar el usuario en la base de datos por el Id
        // TODO Cuidado porque solamente puedo yo ver mi perfil (falta seguridad)
        return "profile";
    }

     /**para ver los pedidos de un usuario**/
     @GetMapping("/user/{userId}/orders")
    public String getUserOrders(Model model, @PathVariable long userId ){
         return "user-orders";
     }

}
