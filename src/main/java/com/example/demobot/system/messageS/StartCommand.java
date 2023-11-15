package com.example.demobot.system.messageS;


import com.example.demobot.system.ClassifiedUpdate;
import com.example.demobot.system.entyS.Answer;
import com.example.demobot.system.entyS.User;
import com.example.demobot.system.messageS.interfaceS.Command;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;


@Component
public class StartCommand implements Command {

    @Override
    public Class handler() {
        return CommandHandler.class;
    }

    @Override
    public Object getFindBy() {
        return "/start";
    }

    @SneakyThrows
    @Override
    public Answer getAnswer(ClassifiedUpdate update, User user) {
        return new SendMessageBuilder().chatId(user.getChatId()).message("Hello!").build();
    }
}
