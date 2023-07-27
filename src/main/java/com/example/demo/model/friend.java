package com.example.demo.model;


import com.example.demo.model.entities.friendstatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;

@Entity
@Table(name = "friends")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friend_id")
    private Long friendId;

    @ManyToOne
    @JoinColumn(name = "user_id1")
    private user user1;

    @ManyToOne
    @JoinColumn(name = "user_id2")
    private user user2;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private friendstatus status;

    @ManyToOne
    @JoinColumn(name = "action_user_id")
    private user actionUser;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}