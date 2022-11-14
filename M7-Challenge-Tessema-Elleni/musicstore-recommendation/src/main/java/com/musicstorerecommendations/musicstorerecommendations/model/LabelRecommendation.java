package com.musicstorerecommendations.musicstorerecommendations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "label_recommendation")
public class LabelRecommendation {

    @Id
    @Column(name = "label_recommendation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotNull
    @Column(name = "label_id")
    private Integer labelId;

    @NotNull
    @Column(name = "user_id")
    private Integer userId;

    private boolean liked;

    public LabelRecommendation() {
    }

    public LabelRecommendation(Integer id, Integer labelId, Integer userId, boolean liked) {
        Id = id;
        this.labelId = labelId;
        this.userId = userId;
        this.liked = liked;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
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
        return "LabelRecommendation{" +
                "Id=" + Id +
                ", labelId=" + labelId +
                ", userId=" + userId +
                ", liked=" + liked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LabelRecommendation that = (LabelRecommendation) o;

        if (liked != that.liked) return false;
        if (!Objects.equals(Id, that.Id)) return false;
        if (!Objects.equals(labelId, that.labelId)) return false;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (labelId != null ? labelId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (liked ? 1 : 0);
        return result;
    }
}
