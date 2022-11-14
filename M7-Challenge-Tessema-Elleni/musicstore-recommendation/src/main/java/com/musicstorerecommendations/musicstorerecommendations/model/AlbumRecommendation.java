package com.musicstorerecommendations.musicstorerecommendations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "album_recommendation")
public class AlbumRecommendation {

    @Id
    @Column(name = "album_recommendation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotNull
    @Column(name = "album_id")
    private Integer albumId;

    @NotNull
    @Column(name = "user_id")
    private Integer userId;

    private boolean liked;

    public AlbumRecommendation() {
    }

    public AlbumRecommendation(Integer id, Integer albumId, Integer userId, boolean liked) {
        Id = id;
        this.albumId = albumId;
        this.userId = userId;
        this.liked = liked;
    }



    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
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
        return "AlbumRecommendation{" +
                "Id=" + Id +
                ", albumId=" + albumId +
                ", userId=" + userId +
                ", liked=" + liked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumRecommendation that = (AlbumRecommendation) o;

        if (liked != that.liked) return false;
        if (!Objects.equals(Id, that.Id)) return false;
        if (!Objects.equals(albumId, that.albumId)) return false;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (albumId != null ? albumId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (liked ? 1 : 0);
        return result;
    }
}
