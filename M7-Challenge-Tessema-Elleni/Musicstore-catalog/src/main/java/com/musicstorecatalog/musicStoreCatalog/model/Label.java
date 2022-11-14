package com.musicstorecatalog.musicStoreCatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "label")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="label_id")
    private int id;
    @NotNull
    @Size(max = 50, message = "can not exceed 50 characters")

    private String name;
    @Size(max = 255, message = "can not exceed 255 characters")
    private String website;

    public Label() {
    }

    public Label(String name, String website) {
        this.name = name;
        this.website = website;
    }

    public Label(int id, String name, String website) {
        this.id = id;
        this.name = name;
        this.website = website;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Lable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Label lable = (Label) o;

        if (id != lable.id) return false;
        if (!Objects.equals(name, lable.name)) return false;
        return Objects.equals(website, lable.website);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        return result;
    }
}
