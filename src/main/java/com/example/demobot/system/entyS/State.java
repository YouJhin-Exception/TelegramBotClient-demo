package com.example.demobot.system.entyS;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
Для чего нам нужно состояние?
К примеру, пользователь захотел пополнить баланс, и мы просим его ввести сумму пополнения.
Если мы не узнаем, что прямо сейчас он вводит сумму пополнения,
то будем обрабатывать его команду: 100, как обычную.
 */
@Entity
@Table(name = "state")
@Getter
@Setter
public class State {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Id
    private Long Id;

    @Column(name = "value")
    private String stateValue;

    public boolean inState() {
        return stateValue != null;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
    private User user;

}
