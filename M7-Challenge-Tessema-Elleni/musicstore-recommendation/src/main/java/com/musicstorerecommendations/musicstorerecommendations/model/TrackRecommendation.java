package com.musicstorerecommendations.musicstorerecommendations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "track_recommendation")
public class TrackRecommendation {
    @Id
    @Column(name = "track_recommendation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotNull
    @Column(name = "track_id")
    private Integer trackId;

    @NotNull
    @Column(name = "user_id")
    private Integer userId;


    private boolean liked;

    public TrackRecommendation() {
    }

    public TrackRecommendation(Integer id, Integer trackId, Integer userId, boolean liked) {
        Id = id;
        this.trackId = trackId;
        this.userId = userId;
        this.liked = liked;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    @Override
    public String toString() {
        return "TrackRecommendation{" +
                "Id=" + Id +
                ", trackId=" + trackId +
                ", userId=" + userId +
                ", liked=" + liked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrackRecommendation that = (TrackRecommendation) o;

        if (liked != that.liked) return false;
        if (!Objects.equals(Id, that.Id)) return false;
        if (!Objects.equals(trackId, that.trackId)) return false;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (trackId != null ? trackId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (liked ? 1 : 0);
        return result;
    }
}
