/*
 */
package Application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Shifan
 */
@Controller
public class LoginController {

    @GetMapping("/")
    public String getLogin() {

        return "login";
    }
}
