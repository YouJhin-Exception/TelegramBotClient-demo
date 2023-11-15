package com.example.demobot.system.messageS;



import com.example.demobot.system.ClassifiedUpdate;
import com.example.demobot.system.entyS.Answer;
import com.example.demobot.system.entyS.User;
import com.example.demobot.system.enumS.TelegramType;
import com.example.demobot.system.messageS.interfaceS.Command;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CommandHandler extends AbstractHandler {

    private HashMap<Object, Command> hashMap = new HashMap<>();

    @Override
    protected HashMap<Object, Command> createMap() {
        return hashMap;
    }

    @Override
    public TelegramType getHandleType() {
        return TelegramType.Command;
    }

    @Override
    public int priority() {
        return 1;
    }

    @Override
    public boolean condition(User user, ClassifiedUpdate update) {
        return hashMap.containsKey(update.getCommandName());
    }

    @Override
    public Answer getAnswer(User user, ClassifiedUpdate update) {
        return hashMap.get(update.getCommandName()).getAnswer(update, user);
    }

}
