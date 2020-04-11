package com.srufanov.socialnetwork.likeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeId implements Serializable {

    @NotNull
    @Column(name = "post_id")
    private Long postId;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

}
