package web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
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
import plug.DAO.Impl.QuerryGen;
import plug.beans.*;
import plug.service.DummyService;

import java.io.*;
import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("")
public class ExampleController{

    @Autowired
    DummyService dummyService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public void indexPage(HttpServletResponse response) throws IOException {
       response.sendRedirect("/starting/profile");
    }

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public ModelAndView getProfile(Model model,HttpServletRequest request, HttpServletResponse response){
        //get logged in username
        Users user= dummyService.getLoggedInUser();
        List<RequestedServices> requestedServices=dummyService.getRequestedServices(user.getUserId());
        List<OfferedServices> offeredServices=dummyService.getOfferedServices(user.getUserId());
        System.out.println(user.getUserId());

        model.addAttribute("requestedServices",requestedServices);
        model.addAttribute("offeredServices",offeredServices);
        model.addAttribute("user", user);
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

    @RequestMapping(value = "/createservice",method =  RequestMethod.GET)
    public ModelAndView createService(Model model)
    {
        Users user= dummyService.getLoggedInUser();
        model.addAttribute("loggedInUser",user);
        return new ModelAndView("serviceCreation","m",model);
    }

    @RequestMapping(value = "/request",method =  RequestMethod.GET)
    public ModelAndView requestService(Model model) throws IOException {
        Users loggedInUser= dummyService.getLoggedInUser();
        model.addAttribute("loggedInUser",loggedInUser);
        model.addAttribute("cities",dummyService.getCities());
        return new ModelAndView("request","m",model);
    }

    @RequestMapping(value = "/offer",method =  RequestMethod.GET)
    public ModelAndView offerService(Model model) throws IOException {
        Users loggedInUser= dummyService.getLoggedInUser();
        model.addAttribute("loggedInUser",loggedInUser);
        model.addAttribute("cities",dummyService.getCities());
        return new ModelAndView("offer","m",model);
    }

    @RequestMapping(value = "/towns",method = RequestMethod.GET)
    @ResponseBody
    public  String getTowns(@RequestParam("id") int id)
    {
        Gson gson = new Gson();
        List<Town> towns=dummyService.getTowns(id);
        return gson.toJson(towns);
    }

    @RequestMapping(value = "/districts",method = RequestMethod.GET)
    @ResponseBody
    public  String getDistricts(@RequestParam("id") int id) throws IOException {
        Gson gson = new Gson();
        List<District> districts=dummyService.getDistricts(id);
        return gson.toJson(districts);
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

    @RequestMapping(value = "/search" , method = RequestMethod.GET)
    public ModelAndView getSearch(Model model)
    {
        model.addAttribute("cities",dummyService.getCities());
        return new ModelAndView("search","m",model);
    }

    @RequestMapping(value = "/search" , method = RequestMethod.POST)
    public ModelAndView postSearch(Model model,
                                   @RequestParam("city") int cityId,
                                   @RequestParam(value = "town",defaultValue = "0") int townId,
                                   @RequestParam("begindate") String beginDate,
                                   @RequestParam("enddate") String endDate,
                                   @RequestParam("searchType") String searchType,
                                   @RequestParam("hidden-tags") String searchWords)
    {
        String[] priolist = new String[3];
        priolist[0] = "tag";
        priolist[1] = "title";
        priolist[2] = "`desc`";
        String begin=formatDate(beginDate);
        String end =formatDate(endDate);
        String serviceQuery = QuerryGen.searchQuery(searchType,
                priolist,
                begin,
                end,
                QuerryGen.tagQuery(searchWords), cityId, townId);
        if(searchType.equals("requested_services")){
            List<RequestedServices> requestedServices = dummyService.getRequestedServicesSearhResult(serviceQuery);
            model.addAttribute("requestedServices",requestedServices);
        }
        else if(searchType.equals("offered_services"))
        {
            List<OfferedServices> offeredServices =dummyService.getOfferedServicesSearchResult(serviceQuery);
            model.addAttribute("requestedServices",offeredServices);
        }
        model.addAttribute("cities",dummyService.getCities());
        return new ModelAndView("search","m",model);
    }

    public static String formatDate(String date)
    {
        String[] numbers=date.split("/");
        return numbers[2]+"-"+numbers[0]+"-"+numbers[1];
    }




}



