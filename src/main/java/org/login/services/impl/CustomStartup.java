package org.login.services.impl;

import org.login.model.domain.User;
import org.login.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by JORGE-HP on 7/7/2017.
 */
@Component
class CustomStartup {
    @Autowired
    UserService userService;

    @EventListener(ContextRefreshedEvent.class)
    void contextRefreshedEvent() {
        User user = userService.findByUsername("janez");
        System.out.println("----startup---");
        System.out.println(user);


    }
}