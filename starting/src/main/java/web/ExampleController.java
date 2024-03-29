package web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import plug.DAO.Impl.QuerryGen;
import plug.beans.*;
import plug.service.DummyService;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


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
        int userId=user.getUserId();
        List<RequestedServices> requestedServices=dummyService.getRequestedServices(user.getUserId());
        List<OfferedServices> offeredServices=dummyService.getOfferedServices(user.getUserId());
        List<ServiceStatusBeanWithUser> pendingServicesToMe = dummyService.getPendingServicesConsumedByMe(userId);
        List<ServiceStatusBeanWithUser> pendingServicesByMe = dummyService.getPendingServicesProvidedByMe(userId);

        List<ServiceStatusBeanWithUser> currentServicesToDo = dummyService.getCurrentServicesToDo(userId);
        List<ServiceStatusBeanWithUser> currentServicesWaiting = dummyService.getCurrentServicesWaiting(userId);


        List<ServiceStatusBeanWithUser> historyOffered = dummyService.getHistoryToMe(userId);
        List<ServiceStatusBeanWithUser> historyRequested = dummyService.getHistoryBeMe(userId);

        List<ServiceStatusBean> serviceStatusList=dummyService.getServiceStasuses();
        model.addAttribute("currentServicesToDo",currentServicesToDo);
        model.addAttribute("currentServicesWaiting",currentServicesWaiting);
        model.addAttribute("historyOffered",historyOffered);
        model.addAttribute("historyRequested",historyRequested);
        model.addAttribute("pendingServicesToMe",pendingServicesToMe);
        model.addAttribute("pendingServicesByMe",pendingServicesByMe);
        model.addAttribute("serviceStatusList",serviceStatusList);
        model.addAttribute("requestedServices",requestedServices);
        model.addAttribute("offeredServices",offeredServices);
        model.addAttribute("loggedInUser", user);
        return  new ModelAndView("profile","m",model);
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(Model model) {
        return  new ModelAndView("login","m",model);
    }
    
    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public ModelAndView signup(Model model) {
        return  new ModelAndView("signup","m",model);
    }
    
    @RequestMapping(value="profile/edit", method = RequestMethod.GET)
    public ModelAndView edit(Model model) {
        Users user= dummyService.getLoggedInUser();
        model.addAttribute("loggedInUser",user);
        return  new ModelAndView("edit","m",model);
    }

    @RequestMapping(value="profile/edit", method = RequestMethod.POST)
    public void editPOST(Model model,
                             @RequestParam("name") String name,
                             @RequestParam("surname") String surname,
                             @RequestParam("password") String password,
                             @RequestParam("avatarId") String avatarId,
                             HttpServletResponse response
                             ) throws IOException {
        Users user= dummyService.getLoggedInUser();
        dummyService.updateProfile(user.getUserId(),name,surname,password,avatarId);
        response.sendRedirect("/starting/profile");
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public void signupPOST(Model model,
                             @RequestParam("name") String name,
                             @RequestParam("surname") String surname,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
//                             @RequestParam("password2") String password2,
                             @RequestParam("avatarId") String avatarId,
                             HttpServletResponse response
                             ) throws IOException {
        dummyService.signup(name,surname,email,password,avatarId);
        Users user = dummyService.getUser(email);
        dummyService.insertUserRole(user.getUserId());
        response.sendRedirect("/starting/login");
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
                            @RequestParam( value = "city",defaultValue = "-1") int cityId,
                            @RequestParam(value = "town" , defaultValue = "-1") int townId,
                            @RequestParam(value = "district" , defaultValue = "-1") int districtId,
                            @RequestParam("begindate") String beginDate,
                            @RequestParam("enddate") String endDate,
                            @RequestParam("duration") String duration,
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
        dummyService.offerService(userId,serviceName,description,hiddenTagList,begin,end,duration,intervalString,cityId,townId,districtId);
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
                              @RequestParam( value = "city",defaultValue = "-1") int cityId,
                              @RequestParam(value = "town" , defaultValue = "-1") int townId,
                              @RequestParam(value = "district" , defaultValue = "-1") int districtId,
                              @RequestParam("begindate") String beginDate,
                              @RequestParam("enddate") String endDate,
                              @RequestParam("duration") String duration,
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
        int everyone=serviceAnyone.equals("1")?1:0;
        dummyService.createService(userId,serviceName,description,hiddenTagList,begin,end,duration,intervalString,everyone,cityId,townId,districtId);
        response.sendRedirect("/starting/profile");
    }

    @RequestMapping(value = "/search" , method = RequestMethod.GET)
    public ModelAndView getSearch(Model model)
    {
        Users user=dummyService.getLoggedInUser();
        if(user!=null){
           model.addAttribute("loggedInUser",user);
        }
        model.addAttribute("cities",dummyService.getCities());
        return new ModelAndView("search","m",model);
    }


    @RequestMapping(value = "/search" , method = RequestMethod.POST)
    public ModelAndView postSearch(Model model,
                                   @RequestParam("city") int cityId,
                                   @RequestParam(value = "town",defaultValue = "-1") int townId,
                                   @RequestParam("begindate") String beginDate,
                                   @RequestParam("enddate") String endDate,
                                   @RequestParam("searchType") String searchType,
                                   @RequestParam("hidden-tags") String searchWords,
                                   @RequestParam(value = "serviceeveryone", defaultValue = "0") Integer service_everyone)
    {
        Splitter.MapSplitter mapSplitter = Splitter.on(",").trimResults().withKeyValueSeparator("-");

        int userId=-1;
        Users user=dummyService.getLoggedInUser();
        if(user!=null){
            userId = user.getUserId();
        }
        if(searchType.equals("offered_services")){
            service_everyone=-1;
        }
        String[] priolist = new String[3];
        priolist[0] = "tag";
        priolist[1] = "title";
        priolist[2] = "`desc`";
        String begin=formatDate(beginDate);
        String end =formatDate(endDate);
        String serviceQuery = QuerryGen.searchQuery(userId,searchType,
                priolist,
                begin,
                end,
                QuerryGen.tagQuery(searchWords), cityId, townId,service_everyone);
        if(searchType.equals("requested_services")){
            List<RequestedServices> requestedServices = dummyService.getRequestedServicesSearhResult(serviceQuery);
            List<List<String>> timesRequest = new ArrayList<List<String>>();
            for(RequestedServices requestedServices1 : requestedServices){
                String[] timesOffArr = requestedServices1.getTime().split(",");
                List<String> dummy = Arrays.asList(timesOffArr);
                timesRequest.add(dummy);}
            model.addAttribute("timesRequest",timesRequest);
            model.addAttribute("requestedServices",requestedServices);
        }
        else if(searchType.equals("offered_services"))
        {
            List<OfferedServices> offeredServices =dummyService.getOfferedServicesSearchResult(serviceQuery);
            List<List<String>> timesOffer = new ArrayList<List<String>>();
            for(OfferedServices offeredService : offeredServices){
            String[] timesOffArr = offeredService.getTime().split(",");
            List<String> dummy = Arrays.asList(timesOffArr);
            timesOffer.add(dummy);}
            model.addAttribute("timesOffer",timesOffer);
            model.addAttribute("offeredServices",offeredServices);

        }
        model.addAttribute("loggedInUser",user);
        model.addAttribute("cities",dummyService.getCities());
        return new ModelAndView("search","m",model);
    }

    @RequestMapping(value = "/service/able",method = RequestMethod.POST)
    @ResponseBody
    public void enableDisableService(HttpServletResponse response,
                                     @RequestParam("serviceid") int serviceId,
                                     @RequestParam("acttype") String actType,
                                     @RequestParam("servicetype") String serviceType){
        int enabled=actType.equals("Active")?1:0;
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
    @RequestMapping(value = "/apply/{type}/{serviceId}/{userId}/{description}",method = RequestMethod.GET)
    public void applyGet(Model model,
                              @PathVariable("type") String type,
                              @PathVariable("serviceId") int serviceId,
                              @PathVariable("userId") int userId,
                              @PathVariable("description") String description,
                              HttpServletResponse response){
        if(type.equals("request")){
            RequestedServices requestedServices=dummyService.getRequestedService(serviceId);
            dummyService.applyService(ServiceType.requested,serviceId,requestedServices.getUserId(),userId,requestedServices.getDuration(),description);
        }
        else if(type.equals("offer")){
            OfferedServices offeredServices=dummyService.getOfferedService(serviceId);
            dummyService.applyService(ServiceType.offered,serviceId,offeredServices.getUserId(),userId,offeredServices.getDuration(),description);
        }
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @RequestMapping(value = "/offered/delete/{id}", method = RequestMethod.GET)
    public void deleteOfferedService(@PathVariable("id") int id,HttpServletResponse response
    ){
        dummyService.deleteOfferedService(id);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @RequestMapping(value = "/requested/delete/{id}", method = RequestMethod.GET)
    public void deleteRequestedService(@PathVariable("id") int id,HttpServletResponse response
    ){
        dummyService.deleteRequestedService(id);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @RequestMapping(value = "/action/{type}/{id}", method = RequestMethod.GET)
    public void action(@PathVariable("id") int id,
                       @PathVariable("type") String type,
                       HttpServletResponse response
    ){
        ServiceStatusBean serviceStatusBean = dummyService.getServiceStatuse(id);
        ServiceStatusType serviceStatusType;
        if("approve".equals(type)){serviceStatusType = ServiceStatusType.Approved;}
        else if("reject".equals(type)){serviceStatusType = ServiceStatusType.Rejected;}
        else if("cancel".equals(type)){serviceStatusType = ServiceStatusType.Withdrawn;}
        else if("complete".equals(type)){serviceStatusType = ServiceStatusType.Completed;}
        else if("fail".equals(type)){serviceStatusType = ServiceStatusType.Failed;}
        else serviceStatusType = ServiceStatusType.Seen;
        if("complete".equals(type)&&serviceStatusBean.getType().equals(ServiceType.offered)){
            dummyService.complete(serviceStatusBean.getProviderId(),serviceStatusBean.getCredit());
        }
        if("complete".equals(type)&&serviceStatusBean.getType().equals(ServiceType.requested)){
            dummyService.complete(serviceStatusBean.getConsumerId(),serviceStatusBean.getCredit());
        }
        dummyService.changeServiceStatusType(id,serviceStatusType);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
    @RequestMapping(value = "/action/{type}/{id}/{responseMsg}", method = RequestMethod.GET)
    public void actionWithDesc(@PathVariable("id") int id,
                       @PathVariable("type") String type,
                       @PathVariable("responseMsg") String responseMsg,
                       HttpServletResponse response
    ){
        ServiceStatusType serviceStatusType;
        if("approve".equals(type)){serviceStatusType = ServiceStatusType.Approved;}
        else if("reject".equals(type)){serviceStatusType = ServiceStatusType.Rejected;}
        else if("cancel".equals(type)){serviceStatusType = ServiceStatusType.Withdrawn;}
        else if("complete".equals(type)){serviceStatusType = ServiceStatusType.Completed;}
        else if("fail".equals(type)){serviceStatusType = ServiceStatusType.Failed;}
        else serviceStatusType = ServiceStatusType.Seen;
        dummyService.changeServiceStatusType(id,serviceStatusType,responseMsg);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView getAdminPage(Model model){
        Users user = dummyService.getLoggedInUser();
        return new ModelAndView("admin","m",model);
    }

    public static String formatDate(String date)
    {
        String[] numbers=date.split("/");
        return numbers[2]+"-"+numbers[0]+"-"+numbers[1];
    }




}



