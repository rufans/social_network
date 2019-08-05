package com.srufanov.socialnetwork.postservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post", schema = "public")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Post extends MainEntity {

    @Column(name = "text", length = 512, nullable = false)
    private String text;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "parent_post_id")
    private Post parentPost;

    @OneToMany(mappedBy = "parentPost", fetch = FetchType.LAZY)
    private List<Post> childPosts = new ArrayList<>();

}
