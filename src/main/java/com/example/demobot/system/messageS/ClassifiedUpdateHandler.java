package com.example.demobot.system.messageS;


/*
Теперь нам нужна ещё прослойка в виде ClassifiedUpdateHandler'a.
Там мы будем доставать пользователя из базы данных и может что-то ещё. Просто добавим его.
 */

import com.example.demobot.system.ClassifiedUpdate;
import com.example.demobot.system.entyS.Answer;
import com.example.demobot.system.serviceS.UserService;
import org.springframework.stereotype.Service;

@Service
public class ClassifiedUpdateHandler {

    private final UserService userService;
    private final HandlersMap commandMap;

    public ClassifiedUpdateHandler(UserService userService, HandlersMap commandMap) {
        this.userService = userService;
        this.commandMap = commandMap;
    }

    public Answer request (ClassifiedUpdate classifiedUpdate) {
        return commandMap.execute(classifiedUpdate,userService.findUserByUpdate(classifiedUpdate));
    }

}
