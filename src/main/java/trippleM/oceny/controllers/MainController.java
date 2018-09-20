package trippleM.oceny.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @RequestMapping("/")
    public String main(){ return "index"; }

//    @RequestMapping("/rejestracja")
//    public String rejestracja(){
//        return "rejestracja";
//    }

//    @RequestMapping("/profil")
//    public String profil(){
//        return "profil";
//    }

    @RequestMapping("/bonus")
    public String bonus(){
        return "bonus";
    }


    @RequestMapping("/bland")
    public String handleError(HttpServletRequest request, Model model) {
        Object errorCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        Object errorMessage = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
//        Object errorException = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
//        Object errorExceptionType = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE);
        model.addAttribute("errorCode", errorCode.toString());
//        model.addAttribute("errorMessage", errorMessage);
//        model.addAttribute("errorException", errorException);
//        model.addAttribute("errorExceptionType", errorExceptionType);
        System.out.printf(errorCode.toString());
        return "error";
    }

}
