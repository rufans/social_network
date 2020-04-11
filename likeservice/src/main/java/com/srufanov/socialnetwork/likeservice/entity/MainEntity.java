package com.srufanov.socialnetwork.likeservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@MappedSuperclass
public class MainEntity {

    @Column
    private LocalDateTime created;

    @JsonIgnore
    @Column
    private LocalDateTime updated;

    @Transient
    private Long timestamp;

    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now(ZoneOffset.UTC);
        updated = created;
    }

    @PreUpdate
    protected void onUpdate() {
        updated = LocalDateTime.now(ZoneOffset.UTC);
    }

    @JsonIgnore
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @JsonIgnore
    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Long getTimestamp() {
        return Optional.ofNullable(created).map(c -> c.toEpochSecond(ZoneOffset.UTC)).orElse(-1L);
    }

}

