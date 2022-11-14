package com.musicstorecatalog.musicStoreCatalog.repository;

import com.musicstorecatalog.musicStoreCatalog.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface LabelRepository extends JpaRepository<Label, Integer> {
    List<Label> findByName(String name);


}
