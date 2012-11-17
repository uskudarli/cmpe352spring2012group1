package web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import plug.beans.*;
import plug.service.DummyService;

import java.io.IOException;
import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("")
public class ExampleController{

    @Autowired
    DummyService dummyService;
    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public ModelAndView getProfile(Model model,HttpServletRequest request, HttpServletResponse response){
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

    @RequestMapping(value = "/createservice/{userId}",method =  RequestMethod.GET)
    public ModelAndView createService(Model model,@PathVariable("userId") int userId)
    {
        model.addAttribute("userId",userId);
        return new ModelAndView("serviceCreation","m",model);
    }

    @RequestMapping(value = "/request/{userId}",method =  RequestMethod.GET)
    public ModelAndView requestService(Model model,@PathVariable("userId") int userId)
    {
        model.addAttribute("userId",userId);
        model.addAttribute("cities",dummyService.getCities());
        return new ModelAndView("request","m",model);
    }

    @RequestMapping(value = "/offer/{userId}",method =  RequestMethod.GET)
    public ModelAndView offerService(Model model,@PathVariable("userId") int userId)
    {
        model.addAttribute("userId",userId);
        model.addAttribute("cities",dummyService.getCities());
//       model.addAttribute("towns",dummyService.getTowns());
        return new ModelAndView("offer","m",model);
    }

    @RequestMapping(value = "/towns",method = RequestMethod.GET)
    @ResponseBody
    public  String getTowns(@RequestParam("id") int id)
    {
        Gson gson = new Gson();
        List<Town> towns=dummyService.getTowns(id);
        String json = gson.toJson(towns);
        return json;
    }

    @RequestMapping(value = "/districts",method = RequestMethod.GET)
    @ResponseBody
    public  String getDistricts(@RequestParam("id") int id)
    {
        Gson gson = new Gson();
        List<District> districts=dummyService.getDistricts(id);
        String json = gson.toJson(districts);
        return json;
    }

    @RequestMapping(value = "/offer" ,method = RequestMethod.POST)
    public void createOffer(Model model,
                            @RequestParam("userId") int userId,
                            @RequestParam("servicename") String serviceName,
                            @RequestParam("description") String description,
                            @RequestParam("tags") String tags,
                            @RequestParam("hidden-tags") String hiddenTagList,
                            @RequestParam("city") int cityId,
                            @RequestParam("town") int townId,
                            @RequestParam("district") int districtId,
                            @RequestParam("begindate") String beginDate,
                            @RequestParam("enddate") String endDate,
                            HttpServletRequest request,
                            HttpServletResponse response
    ) throws IOException {
        String begin=formatDate(beginDate);
        String end =formatDate(endDate);
        dummyService.offerService(userId,serviceName,description,hiddenTagList,begin,end);
        response.sendRedirect("/starting/profile");
    }

    @RequestMapping(value = "/request" ,method = RequestMethod.POST)
    public void createRequest(Model model,
                            @RequestParam("userId") int userId,
                            @RequestParam(value = "check",defaultValue = "0",required = false) String serviceAnyone,
                            @RequestParam("servicename") String serviceName,
                            @RequestParam("description") String description,
                            @RequestParam("tags") String tags,
                            @RequestParam("hidden-tags") String hiddenTagList,
                            @RequestParam("city") int cityId,
                            @RequestParam("town") int townId,
                            @RequestParam("district") int districtId,
                            @RequestParam("begindate") String beginDate,
                            @RequestParam("enddate") String endDate,
                            HttpServletRequest request,
                            HttpServletResponse response
    ) throws IOException {
        String begin=formatDate(beginDate);
        String end =formatDate(endDate);
        int everyone=serviceAnyone.equals("1")?1:0;
        dummyService.createService(userId,serviceName,description,hiddenTagList,begin,end,everyone);
        response.sendRedirect("/starting/profile");
    }


    public static String formatDate(String date)
    {
        String[] numbers=date.split("/");
        String result=numbers[2]+"-"+numbers[0]+"-"+numbers[1];
        return  result;
    }




}



