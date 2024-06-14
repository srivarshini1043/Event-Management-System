package com.Event.Management.CustomController;

        import java.text.SimpleDateFormat;
        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.Iterator;
        import java.util.List;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;
        import org.springframework.web.multipart.MultipartFile;

        import com.Event.Management.Model.EventModelData;
        import com.Event.Management.Model.UserModelData;
        import com.Event.Management.Services.EventServices;
        import com.Event.Management.Services.UserServices;
        import org.springframework.web.bind.annotation.GetMapping;


@RestController
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired(required = true)
    UserServices topics;

    @Autowired(required = true)
    EventServices eventServices;

    @RequestMapping("/getdata")

    public List<UserModelData> getdata() {

        return topics.getAllTopics();

    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)

    public Object addUser(@RequestBody UserModelData topicsdata) {
        Object status = topics.adduser(topicsdata, topicsdata.getemail());
        ResponseData r = new ResponseData();
        r.setResponse("" + status);
        return status;

    }

    @RequestMapping(value = "/getuser", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public boolean getUser(@RequestParam String user, @RequestParam String password) {
        List<UserModelData> listdata = topics.getuserVierify(user);
        return listdata.get(0).getpassword().equals(password);
    }

    @RequestMapping(value = "/addevent", method = RequestMethod.POST)
    public Boolean adduserEvent(@RequestBody EventModelData eModelData	) {
        Boolean res = eventServices.addEvent(eModelData,eModelData.geteventtype(),eModelData.getuser());
        return res;
    }



    @GetMapping("/getallEvent")
    public List<EventModelData> GetAllEvent() {
        return eventServices.getAllEvent();
    }



    @GetMapping("/getuserEvent")
    public List<EventModelData> GetUserEvent(@RequestParam(value = "user") String user) {
        return eventServices.getuserEvent(user);
    }




    @RequestMapping(value = "/DeleteEvent",method = RequestMethod.DELETE)
    @CrossOrigin(origins = "*")
    public Boolean DeleteEvent(@RequestParam(name = "id") Integer id ) {
        Boolean resBoolean=  eventServices.DeleteRowEvent(id);
        return resBoolean;
    }


}

