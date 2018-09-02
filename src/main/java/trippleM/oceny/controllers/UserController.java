package trippleM.oceny.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import trippleM.oceny.entities.User;
import trippleM.oceny.forms.RegisterForm;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @PostMapping("/rejestracja")
    public String registerFormAction(){
//            @ModelAttribute @Valid RegisterForm registerForm,
//            BindingResult bindingResult,
//            Model model) {
//
//        if (registerForm.getPass() == null
//                || !registerForm.getPass().equals(registerForm.getPassRepeat())) {
//            bindingResult.rejectValue("pass", "123",
//                    "Hasła muszą być takie same");
//            bindingResult.rejectValue("passRepeat", "123",
//                    "Hasła muszą być takie same");
//        }
//        if(!registerForm.getEmail().contains("@")){
//            model.addAttribute("emailError", "Błędny email");
//        }
//        System.out.println(registerForm);
//        System.out.println(bindingResult.toString());
//        System.out.println(registerForm.getPass());

//        List<User> allByEmail = userRepository.findAllByEmail(registerForm.getEmail());
//        if(!allByEmail.isEmpty()){
//            bindingResult.rejectValue("email", "123",
//                    "Dany email już istnieje.");
//        }
//
//        if (bindingResult.hasErrors()) {
//            return "rejestracja";
//        }
//        return "error";
        return "rejestracja";
    }
}
