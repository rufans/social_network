package com.srufanov.socialnetwork.userservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.srufanov.socialnetwork.userservice.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"friends", "friendRequests", "roles"})
@NoArgsConstructor
@AllArgsConstructor
public class User extends MainEntity {

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private Set<Role> roles = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "requester")
    private Set<Friendship> friendRequests = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "friend")
    private Set<Friendship> friends = new HashSet<>();

    public User(@NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username,
                @NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 100) String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
