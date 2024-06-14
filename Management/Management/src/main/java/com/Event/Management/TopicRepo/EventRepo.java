package com.Event.Management.TopicRepo;

        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

        import com.Event.Management.Model.EventModelData;
        import java.util.*;

@Repository
public interface  EventRepo extends CrudRepository<EventModelData,Integer> {


    @Query(value = "select eventtype from event where eventtype=?1 and user=?2",nativeQuery = true)
    Object   exitEventType(String eventtype,String user) ;

    @Query(value = "SELECT * FROM eventmanager.event where eventdate>date(now())",nativeQuery = true)
    List<EventModelData>  eventgetalldata();


    @Query(value = "SELECT * FROM eventmanager.event where user=?1",nativeQuery = true)
    List<EventModelData>  getuserEvent(String user);


}
