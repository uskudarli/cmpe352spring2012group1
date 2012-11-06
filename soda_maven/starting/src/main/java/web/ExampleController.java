package web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import plug.beans.OfferedServices;
import plug.beans.RequestedServices;
import plug.beans.UserBean;
import plug.beans.Users;
import plug.service.DummyService;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("")
public class ExampleController{

    @Autowired
    DummyService dummyService;
    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public ModelAndView handleRequestInternal(Model model,HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName(); //get logged in username
        Users user= dummyService.getLoggedInUser(email);
        List<RequestedServices> requestedServices=dummyService.getRequestedServices(user.getUserId());
        List<OfferedServices> offeredServices=dummyService.getOfferedServices(user.getUserId());
        System.out.println(user.getUserId());

        model.addAttribute("requestedServices",requestedServices);
        model.addAttribute("offeredServices",offeredServices);
        model.addAttribute("user", user);
        System.out.println(auth.getPrincipal());
        return  new ModelAndView("profile","m",model);
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(Model model) {

        return  new ModelAndView("login","m",model);
    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public ModelAndView loginerror(Model model) {

        model.addAttribute("error", "true");
        return  new ModelAndView("login","m",model);

    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView logout(Model model) {

        return  new ModelAndView("login","m",model);

    }
}



