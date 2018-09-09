package trippleM.oceny.controllers;

//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import trippleM.oceny.entities.User;
import trippleM.oceny.forms.RegisterForm;
import trippleM.oceny.repositories.UserRepo;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private UserRepo userRepository;

    @Autowired
    public UserController(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/rejestracja")
    public String rejestracja(Model model, RegisterForm registerForm){
        model.addAttribute("registerForm", registerForm);
        return "rejestracja";
    }

    @PostMapping("/rejestracja")
    public String registerFormAction(
            @ModelAttribute @Valid RegisterForm registerForm,
            BindingResult bindingResult,
            Model model){

        if(registerForm.getPass() == null
                || !registerForm.getPass().equals(registerForm.getPassRepeat())){
            bindingResult.rejectValue("pass", "123",
                    "Hasła muszą być takie same");
            bindingResult.rejectValue("passRepeat", "123",
                    "Hasła muszą być takie same");
        }
//        if(!registerForm.getEmail().contains("@")){
//            model.addAttribute("emailError", "Błędny email");
//        }
        System.out.println(registerForm);
        System.out.println(bindingResult.toString());
        System.out.println(registerForm.getPass());

        List<User> allByEmail = userRepository.findAllByEmail(registerForm.getEmail());
        if(!allByEmail.isEmpty()){
            bindingResult.rejectValue("email", "123",
                    "Dany email już istnieje.");
        }

        if(bindingResult.hasErrors()){
            return "rejestracja";
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setEmail(registerForm.getEmail());
        user.setFirstName(registerForm.getFirstName());
        user.setLastName(registerForm.getLastName());
        user.setAdded(new Date());
        user.setActive(Boolean.TRUE);
        user.setGitHub(registerForm.getGitHub());
        user.setPhoneNummber(registerForm.getPhoneNumber());

        user.setPassword(bCryptPasswordEncoder.encode(registerForm.getPass()));

        userRepository.save(user);
        return "good_job";
//        return "redirect:/";
    }

    @GetMapping("/logowanie")
    public String loginForm(){ return "logowanie"; }

    @GetMapping("/panel_administratora")
    public String adminPanel(){ return "admin_panel"; }

    @GetMapping("/oceny")
    public String marks(){ return "wpisywanie_ocen"; }

    @GetMapping("/zmiana_danych")
    public String changePersonalData(){ return "zmiana_danych"; }

//    @GetMapping("/logut")
//    public String logout(){ return "logout"; }

    @GetMapping("/zapis")
    public String save(){ return "good_job"; }

    @RequestMapping ("/profil")
    public String profilFill(Model model, Authentication auth) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            User loggedUser = userRepository.findOneByEmail(userDetails.getUsername());
//        List<User> users = userRepository.findAll();
            model.addAttribute("usersModel", loggedUser);
        return "profil";}

}

