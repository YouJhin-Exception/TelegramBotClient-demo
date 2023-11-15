package com.example.demobot.system.messageS.interfaceS;
/*
Дальше нам нужно создать обработчик сообщений, в нашем случае они будут разные и их будет много,
поэтому создадим интерфейс Handler.

Обработчик выполняет функцию хранения команд.
 */


import com.example.demobot.system.ClassifiedUpdate;
import com.example.demobot.system.entyS.Answer;
import com.example.demobot.system.entyS.User;
import com.example.demobot.system.enumS.TelegramType;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public interface Handler {

    // Какой тип сообщения будет обработан
    TelegramType getHandleType();

    // Приоритет обработчика
    int priority();

    // Условия, при которых мы воспользуемся этим обработчиком
    boolean condition(User user, ClassifiedUpdate update);

    // В этом методе, с помощью апдейта мы будем получать answer
    Answer getAnswer(User user, ClassifiedUpdate update);
}
