/*
 */
package Application;

import java.io.IOException;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Shifan
 */
@Controller
public class LoginController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/board").setViewName("board");
    }

    @GetMapping("/login")
    public String userLogin(UserModel userModel) {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@Valid UserModel userModel, BindingResult bindingResult) throws IOException {

        if (bindingResult.hasErrors()) {
            return "login";
        }

        return "redirect:/board";
    }

}
