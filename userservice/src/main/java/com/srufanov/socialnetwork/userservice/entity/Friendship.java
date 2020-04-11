package com.srufanov.socialnetwork.userservice.entity;

import com.srufanov.socialnetwork.userservice.enumeration.FriendshipStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@IdClass(FriendshipId.class)
@Entity
@Table(name = "friendship", schema = "public")
public class Friendship {

    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User requester;

    @Id
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User friend;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private FriendshipStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

}
