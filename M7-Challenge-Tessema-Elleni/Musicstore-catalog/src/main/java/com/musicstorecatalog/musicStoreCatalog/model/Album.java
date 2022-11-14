package com.musicstorecatalog.musicStoreCatalog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private int id;
    @NotEmpty
    @NotNull
    @Size(max = 50, message = "can not exceed 50 characters")
    private String title;


    @NotNull
    @Column(name ="artist_id")
    private int artistId;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate release_date;
    @Column(name = "label_id")
    @NotNull
    private int labelId;
    @Column(name = "list_price")
    @NotNull
    @Digits(integer = 2, fraction = 2)
    private BigDecimal price;

    public Album() {
    }

    public Album(int id, String title, int artistId, LocalDate release_date, int labelId, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
        this.release_date = release_date;
        this.labelId = labelId;
        this.price = price;
    }

    public Album(String title, int artistId, LocalDate release_date, int labelId, BigDecimal price) {
        this.title = title;
        this.artistId = artistId;
        this.release_date = release_date;
        this.labelId = labelId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public LocalDate getrelease_date() {
        return release_date;
    }

    public void setrelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artistId=" + artistId +
                ", release_date=" + release_date +
                ", labelId=" + labelId +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (id != album.id) return false;
        if (artistId != album.artistId) return false;
        if (labelId != album.labelId) return false;
        if (!Objects.equals(title, album.title)) return false;
        if (!Objects.equals(release_date, album.release_date))
            return false;
        return Objects.equals(price, album.price);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + artistId;
        result = 31 * result + (release_date != null ? release_date.hashCode() : 0);
        result = 31 * result + labelId;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
