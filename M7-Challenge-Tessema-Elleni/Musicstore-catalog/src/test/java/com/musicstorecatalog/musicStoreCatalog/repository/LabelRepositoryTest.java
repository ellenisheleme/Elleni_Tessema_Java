package com.musicstorecatalog.musicStoreCatalog.repository;

import com.musicstorecatalog.musicStoreCatalog.model.Label;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabelRepositoryTest {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    LabelRepository labelRepository;

    @Before
    public void setUp() {

        trackRepository.deleteAll();
        albumRepository.deleteAll();
        artistRepository.deleteAll();
        labelRepository.deleteAll();

    }

    @Test
    public void shouldCreateFindAndDeleteLabel() {

        Label label = new Label();
        label.setName("J&A");
        label.setWebsite("www.jlonnon.com");

        label= labelRepository.save(label);

        Optional<Label> optionalLabel = labelRepository.findById(label.getId());

        assertEquals(optionalLabel.get(), label);

       labelRepository.deleteById(label.getId());

        optionalLabel = labelRepository.findById(label.getId());

        assertFalse(optionalLabel.isPresent());

    }
    @Test
    public void shouldUpdateLabel() {

        Label label = new Label();
        label.setName("J&A");
        label.setWebsite("www.jlonnon.com");

        label= labelRepository.save(label);

        label.setWebsite("www.johnlennon.com");

        labelRepository.save(label);

        Optional<Label> updatedLabel = labelRepository.findById(label.getId());

        assertEquals(updatedLabel.get(), label);

    }

    @Test
    public void shouldGetAllLabel() {

        Label label = new Label();
        label.setName("J&A");
        label.setWebsite("www.jlonnon.com");

        Label label1 = new Label();
        label1.setName("M&J");
        label1.setWebsite("www.mjackson.com");

        label= labelRepository.save(label);
        label1 = labelRepository.save(label1);

        List<Label> labelList = labelRepository.findAll();

        assertEquals(labelList.size(), 2);

    }

    @Test
    public void shouldGetLabelByByName() {

        Label label = new Label();
        label.setName("J&A");
        label.setWebsite("www.jlonnon.com");

        Label label1 = new Label();
        label1.setName("M&J");
        label1.setWebsite("www.mjackson.com");

        label = labelRepository.save(label);
        label1 = labelRepository.save(label1);

        List<Label> labelByName = labelRepository.findByName("J&A");

        assertEquals(new HashSet<Label>(Arrays.asList(label)), new HashSet<Label>(labelByName));
    }

}