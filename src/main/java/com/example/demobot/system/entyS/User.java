package com.example.demobot.system.entyS;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private Long chatId;

    @Column(nullable = false)
    private Long permissions;

    /*
    я использую у permissions тип Long, потому что обычно это:
    0 - Default User
    1 - Какой-нибудь VIP
    2 - Moderator
    3 - Admin
     */


    // хз откуда ???
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
    private State state;

    @Column(unique = true)
    private String userName;

}
