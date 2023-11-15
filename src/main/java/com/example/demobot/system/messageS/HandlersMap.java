package com.example.demobot.system.messageS;


/*
Нам нужно собрать все обработчики в одном месте. И отправить наш ClassifiedUpdate в эту бездонную бочку.
Назовём эту штуку HandlersMap, просто потому что я снова распихиваю обработчики по хэшмапе
 */

import com.example.demobot.system.ClassifiedUpdate;
import com.example.demobot.system.entyS.Answer;
import com.example.demobot.system.entyS.User;
import com.example.demobot.system.enumS.TelegramType;
import com.example.demobot.system.messageS.interfaceS.Handler;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Component
public class HandlersMap {
    private HashMap<TelegramType, List<Handler>> hashMap = new HashMap<>();
    private final List<Handler> handlers;

    // Тут точно также находим все обработчики, просто в первом случае я использовал
    // @Autowired. Это немного лучше.
    public HandlersMap(List<Handler> handlers) {
        this.handlers = handlers;
    }

    @PostConstruct
    private void init(){
        for (Handler handler : handlers){
            if (!hashMap.containsKey(handler.getHandleType()))
                hashMap.put(handler.getHandleType(),new ArrayList<>());

            hashMap.get(handler.getHandleType()).add(handler);
        }

        hashMap.values().forEach(h -> h.sort(new Comparator<Handler>() {
            @Override
            public int compare(Handler o1, Handler o2) {
                return o2.priority() - o1.priority();
            }
        }) );

    }

     public Answer execute (ClassifiedUpdate classifiedUpdate, User user){
        if (!hashMap.containsKey(classifiedUpdate.getTelegramType()))
            return new Answer();

        for (Handler handler : hashMap.get(classifiedUpdate.getTelegramType())) {
            if (handler.condition(user,classifiedUpdate))
                return handler.getAnswer(user,classifiedUpdate);
        }
        return null;
    }
}
