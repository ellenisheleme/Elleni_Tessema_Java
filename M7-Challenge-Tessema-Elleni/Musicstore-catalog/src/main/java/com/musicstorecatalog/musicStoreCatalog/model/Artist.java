package com.musicstorecatalog.musicStoreCatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "artist_id")
    private int id;
    @NotNull
    @NotEmpty
    @Size(max = 50, message = "name can not exceed 50 characters")
    private String name;
    @Size(max = 255, message = "can not exceed 255 characters")
    private String instagram;
    @Size(max = 255, message = "can not exceed 255 characters")
    private String twitter;

    public Artist() {
    }

    public Artist(String name, String instagram, String twitter) {
        this.name = name;
        this.instagram = instagram;
        this.twitter = twitter;
    }

    public Artist(int id, String name, String instagram, String twitter) {
        this.id = id;
        this.name = name;
        this.instagram = instagram;
        this.twitter = twitter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instagram='" + instagram + '\'' +
                ", twitter='" + twitter + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (id != artist.id) return false;
        if (!Objects.equals(name, artist.name)) return false;
        if (!Objects.equals(instagram, artist.instagram)) return false;
        return Objects.equals(twitter, artist.twitter);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (instagram != null ? instagram.hashCode() : 0);
        result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
        return result;
    }
}
