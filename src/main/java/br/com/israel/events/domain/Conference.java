package br.com.israel.events.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_conference")
@Getter
@Setter
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConference;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private String adress;

}
