package com.musicstorerecommendations.musicstorerecommendations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "artist_recommendation")
public class ArtistRecommendation {
    @Id
    @Column(name = "artist_recommendation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotNull
    @Column(name = "artist_id")
    private Integer artistId;
    @NotNull
    @Column(name = "user_id")
    private Integer userId;

    private boolean liked;

    public ArtistRecommendation() {
    }

    public ArtistRecommendation(Integer id, Integer artistId, Integer userId, boolean liked) {
        Id = id;
        this.artistId = artistId;
        this.userId = userId;
        this.liked = liked;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
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
        return "ArtistRecommendation{" +
                "Id=" + Id +
                ", artistId=" + artistId +
                ", userId=" + userId +
                ", liked=" + liked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistRecommendation that = (ArtistRecommendation) o;

        if (liked != that.liked) return false;
        if (!Objects.equals(Id, that.Id)) return false;
        if (!Objects.equals(artistId, that.artistId)) return false;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (artistId != null ? artistId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (liked ? 1 : 0);
        return result;
    }
}
