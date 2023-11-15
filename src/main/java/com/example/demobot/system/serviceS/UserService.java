package com.example.demobot.system.serviceS;


import com.example.demobot.system.ClassifiedUpdate;
import com.example.demobot.system.entyS.State;
import com.example.demobot.system.entyS.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final StateRepository stateRepository;

    public UserService(UserRepository userRepository, StateRepository stateRepository) {
        this.userRepository = userRepository;
        this.stateRepository = stateRepository;
    }

    public User findUserByUpdate(ClassifiedUpdate classifiedUpdate) {

        // Проверим, существует ли этот пользователь.
        if (userRepository.findByChatId(classifiedUpdate.getUserId()) != null){
            User user = userRepository.findByChatId(classifiedUpdate.getUserId());

            // Если мы не смогли до этого записать имя пользователя, то запишем его.
            if(user.getUserName() == null && classifiedUpdate.getUserName() != null)
                user.setUserName(classifiedUpdate.getUserName());

            // Проверим менял ли пользователя имя.
            if(user.getUserName() != null)
                if (!user.getUserName().equals(classifiedUpdate.getUserName()))
                    user.setUserName(classifiedUpdate.getUserName());

            if(!user.getName().equals(classifiedUpdate.getName()))
                user.setName(classifiedUpdate.getName());

            return user;
        }

        try {
            User user = new User();
            user.setName(classifiedUpdate.getName());
            user.setPermissions(0L);
            user.setChatId(classifiedUpdate.getUserId());
            user.setUserName(classifiedUpdate.getUserName());

            State state = new State();
            state.setStateValue(null);
            state.setUser(user);

            stateRepository.save(state);

            user.setState(state);
            userRepository.save(user);

            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
