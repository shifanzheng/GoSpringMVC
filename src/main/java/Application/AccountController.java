/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Shifan
 */
@Controller
public class AccountController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/board").setViewName("board");
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/account")
    public String creatAccount(Model model) {
        UserModel u = new UserModel();
        model.addAttribute("userModel", new UserModel());
        return "account";
    }

    @PostMapping("/account")
    public String accountSubmit(@Valid @ModelAttribute UserModel userModel, BindingResult bindingResult) throws IOException {

        if (bindingResult.hasErrors()) {
            return "account";
        }
        userRepository.save(userModel);
        return "redirect:/board";
    }

}
