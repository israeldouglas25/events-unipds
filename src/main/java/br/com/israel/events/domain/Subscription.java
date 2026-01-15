package br.com.israel.events.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_subscription")
@Getter
@Setter
public class Subscription {

    @Id
    private SubscriptionID id;

    private LocalDateTime createdAt;
    private Integer level;

    @Column(name = "unique_id", nullable = false, length = 45)
    private String uniqueID;

}
