package com.nighthawk.spring_portfolio.mvc.player;

import com.nighthawk.spring_portfolio.mvc.person.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String playerName;
    private String position;

    @ManyToOne
    private Person person;

    @Override
    @JoinColumn(name = "person")
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public Player(String playerName, String position, Person person) {
        this.playerName = playerName;
        this.person = person;
        this.position = position;
    }
}
