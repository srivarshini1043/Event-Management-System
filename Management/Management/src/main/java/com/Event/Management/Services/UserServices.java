package com.Event.Management.Services;


import java.sql.Array;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Event.Management.Model.UserModelData;
import com.Event.Management.TopicRepo.TopicRepo;

@Service
public class UserServices {

    @Autowired
    TopicRepo topicRepo;
    public int status = 0;

    public List<UserModelData> getAllTopics() {
        List<UserModelData> list = new ArrayList<>();
        topicRepo.findAll().forEach(data -> {
            list.add(data);
        });
        return list;
    }

    public Object adduser(UserModelData udata, String email) {
        Object result = checkuser(email.toString());
        if (result == null) {
            topicRepo.save(udata);
            status = 0;

        } else {
            status = 1;
        }
        return status;

    }

    public Object checkuser(String uData) {
        return topicRepo.exituser(uData);
    }

    public List<UserModelData> getuserVierify(String user) {

        return topicRepo.findByEmail(user);

    }
}
