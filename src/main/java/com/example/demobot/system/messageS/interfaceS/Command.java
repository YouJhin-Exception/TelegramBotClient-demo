package com.example.demobot.system.messageS.interfaceS;
/*
Теперь нам нужно создать команды для обработчика.
Создадим интерфейс Command.
 */


import com.example.demobot.system.ClassifiedUpdate;
import com.example.demobot.system.entyS.Answer;
import com.example.demobot.system.entyS.User;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public interface Command {

    // Каким обработчиком будет пользоваться команда
    Class handler();

    // С помощью чего мы найдём эту команду
    Object getFindBy();

    // Ну и тут мы уже получим ответ на самом деле
    Answer getAnswer(ClassifiedUpdate update, User user);

}
