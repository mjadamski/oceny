package trippleM.oceny.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String main(){
        return "index";
    }

    @RequestMapping("/logowanie")
    public String logowanie(){
        return "logowanie";
    }

//    @RequestMapping("/rejestracja")
//    public String rejestracja(){
//        return "rejestracja";
//    }

    @RequestMapping("/profil")
    public String profil(){
        return "profil";
    }

    @RequestMapping("/bonus")
    public String rejestracja(){
        return "bonus";
    }

}
