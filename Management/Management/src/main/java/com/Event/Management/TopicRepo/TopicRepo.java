package com.Event.Management.TopicRepo;

         import org.springframework.data.jpa.repository.JpaRepository;
         import org.springframework.data.jpa.repository.Query;
         import org.springframework.data.repository.CrudRepository;
         import org.springframework.stereotype.Repository;

         import com.Event.Management.Model.UserModelData;

         import java.sql.Array;
         import java.util.List;


@Repository
public interface TopicRepo extends CrudRepository<UserModelData,Integer>{


    List<UserModelData> findByEmail(String email);

    @Query(value = "select email from user where email=?1",nativeQuery = true)
    Object exituser(String email) ;




}
