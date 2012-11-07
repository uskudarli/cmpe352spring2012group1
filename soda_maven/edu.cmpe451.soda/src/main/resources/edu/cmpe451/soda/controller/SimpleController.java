package edu.cmpe451.soda.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import edu.cmpe451.soda.entity.RequestedServices;
import edu.cmpe451.soda.entity.OfferedServices;
import edu.cmpe451.soda.entity.Users;
import edu.cmpe451.soda.service.SimpleService;
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


import java.security.Principal;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: aurora
 * Date: 11/7/12
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("")
public class SimpleController {

    @Autowired
    SimpleService simpleService;
    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public ModelAndView handleRequestInternal(Model model,HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName(); //get logged in username
        Users user= simpleService.getLoggedInUser(email);
        List<RequestedServices> requestedServices=simpleService.getRequestedServices(user.getUserId());
        List<OfferedServices> offeredServices=simpleService.getOfferedServices(user.getUserId());
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
