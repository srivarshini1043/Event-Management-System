package com.Event.Management.Services;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.web.bind.annotation.RequestParam;

        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.List;
        import com.Event.Management.Model.EventModelData;
        import com.Event.Management.Model.UserModelData;
        import com.Event.Management.TopicRepo.EventRepo;

@Service
public class EventServices {

    public Boolean status=false;
    public Boolean deleBoolean = false;

    @Autowired
    EventRepo eventrepo;



    public Boolean addEvent(EventModelData eventModelData,String Eventtype,String user) {
        Object EventType=eventrepo.exitEventType(Eventtype,user);

        if(EventType==null){
            eventrepo.save(eventModelData);
            status=true;
        }else{
            status=false;
        }

        return status;

    }

    public List<EventModelData> getAllEvent() {
        List<EventModelData> list = eventrepo.eventgetalldata();
        return list;
    }

    public  List<EventModelData> getuserEvent(String user){
        List<EventModelData> list = eventrepo.getuserEvent(user);
        return list;

    }


    public boolean DeleteRowEvent(Integer id) {
        try {
            eventrepo.deleteById(id);
            deleBoolean = true;

        } catch (Exception ex) {
            deleBoolean = false;
        }

        return deleBoolean;

    }

}
