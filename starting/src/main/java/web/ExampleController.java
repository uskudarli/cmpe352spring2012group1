package web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
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
import java.util.Formatter;
import java.util.List;
import java.util.Locale;


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
        model.addAttribute("requestedServices",requestedServices);
        model.addAttribute("offeredServices",offeredServices);
        model.addAttribute("loggedInUser", user);
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
        List<City> cities=dummyService.getCities();
        model.addAttribute("loggedInUser",loggedInUser);
        model.addAttribute("cities",cities);
        return new ModelAndView("request","m",model);
    }

    @RequestMapping(value = "/offer",method =  RequestMethod.GET)
    public ModelAndView offerService(Model model) throws IOException {
        Users loggedInUser= dummyService.getLoggedInUser();
        model.addAttribute("loggedInUser",loggedInUser);
        model.addAttribute("cities",dummyService.getCities());
        return new ModelAndView("offer","m",model);
    }

    @RequestMapping(value = "/towns",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getTowns(@RequestParam("id") int id,HttpServletResponse response)
    {
        Gson gson = new Gson();
        List<Town> towns=dummyService.getTowns(id);
        String result = gson.toJson(towns);
        return result;
    }

    @RequestMapping(value = "/districts",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
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
                            @RequestParam("timeinterval1") String timeInterval1,
                            @RequestParam("timeinterval2") String timeInterval2,
                            @RequestParam("timeinterval3") String timeInterval3,
                            @RequestParam("timeinterval4") String timeInterval4,
                            @RequestParam("timeinterval5") String timeInterval5,
                            @RequestParam("timeinterval6") String timeInterval6,
                            @RequestParam("timeinterval7") String timeInterval7,
                            @RequestParam("timeinterval8") String timeInterval8,
                            @RequestParam("timeinterval9") String timeInterval9,
                            @RequestParam("timeinterval10") String timeInterval10,
                            @RequestParam("timeinterval11") String timeInterval11,
                            @RequestParam("timeinterval12") String timeInterval12,
                            @RequestParam("timeinterval13") String timeInterval13,
                            @RequestParam("timeinterval14") String timeInterval14,
                            HttpServletRequest request,
                            HttpServletResponse response
    ) throws IOException {
        String interval1=timeInterval1+"-"+timeInterval2;
        String interval2=timeInterval3+"-"+timeInterval4;
        String interval3=timeInterval5+"-"+timeInterval6;
        String interval4=timeInterval7+"-"+timeInterval8;
        String interval5=timeInterval9+"-"+timeInterval10;
        String interval6=timeInterval11+"-"+timeInterval12;
        String interval7=timeInterval13+"-"+timeInterval14;
        String intervalString=interval1+","+interval2+","+interval3+","+interval4+","+interval5+","+interval6+","+interval7;
        String begin=formatDate(beginDate);
        String end =formatDate(endDate);
        dummyService.offerService(userId,serviceName,description,hiddenTagList,begin,end,intervalString,cityId,townId,districtId);
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
        dummyService.createService(userId,serviceName,description,hiddenTagList,begin,end,everyone,cityId,townId,districtId);
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

    @RequestMapping(value = "/service/able",method = RequestMethod.POST)
    @ResponseBody
    public void enableDisableService(HttpServletResponse response,
                                     @RequestParam("serviceid") int serviceId,
                                     @RequestParam("acttype") String actType,
                                     @RequestParam("servicetype") String serviceType){
        int enabled=actType.equals("activate")?1:0;
        if(serviceType.equals("offer")){
            dummyService.enableDisableOffer(serviceId,enabled);
        }

        else if(serviceType.equals("request")){
            dummyService.enableDisableRequest(serviceId,enabled);
        }

        response.setStatus(204);
    }

    @RequestMapping(value = "/service/delete",method = RequestMethod.POST)
    @ResponseBody
    public void deleteService(HttpServletResponse response,
                                     @RequestParam("serviceid") int serviceId,
                                     @RequestParam("servicetype") String serviceType){
        if(serviceType.equals("offer")){
            dummyService.deleteOfferedService(serviceId);
        }

        else if(serviceType.equals("request")){
            dummyService.deleteRequestedService(serviceId);
        }

        response.setStatus(204);
    }

    public static String formatDate(String date)
    {
        String[] numbers=date.split("/");
        return numbers[2]+"-"+numbers[0]+"-"+numbers[1];
    }




}



