package com.musicstorecatalog.musicStoreCatalog.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicstorecatalog.musicStoreCatalog.model.Album;
import com.musicstorecatalog.musicStoreCatalog.model.Track;
import com.musicstorecatalog.musicStoreCatalog.model.Label;
import com.musicstorecatalog.musicStoreCatalog.repository.TrackRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TrackController.class)
public class TrackControllerTest {

    @MockBean
    private TrackRepository repository;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    private Track inputTrack1;
    private Track inputTrack2;
    private Track inputTrack3;

    private String inputTrack1Json;
    private String inputTrack2Json;

    private Track outputTrack1;
    private Track outputTrack2;
    private Track outputTrack3;

    private String outputTrack1Json;
    private String outputTrack2Json;

    private List<Track> inputTrackList = new ArrayList<>();

    private List<Track> outputTrackList = new ArrayList<>();
    private String outputTrackListJson;

    @Before
    public void setUp()throws Exception {

        inputTrack1 = new Track(6, "evermore", 60);
        inputTrack2 = new Track(2, "Fearless", 75);
        inputTrack3 = new Track(5, "Lover", 67);


        inputTrackList.add(inputTrack1);
        inputTrackList.add(inputTrack2);
        inputTrackList.add(inputTrack3);

        inputTrack1Json = mapper.writeValueAsString(inputTrack1);
        inputTrack2Json = mapper.writeValueAsString(inputTrack2);

        outputTrack1 = new Track(1, 6, "evermore", 60);
        outputTrack2 = new Track(2, 2, "Fearless", 75);
        outputTrack3 = new Track(3, 5, "Lover", 67);

        outputTrackList.add(outputTrack1);
        outputTrackList.add(outputTrack2);


        outputTrack1Json = mapper.writeValueAsString(outputTrack1);
        outputTrack2Json = mapper.writeValueAsString(outputTrack2);

        outputTrackListJson = mapper.writeValueAsString(outputTrackList);

    }

    @Test
    public void shouldReturn201AndTrackOnPost()throws Exception {

        doReturn(outputTrack1).when(repository).save(inputTrack1);

        mockMvc.perform(
                        post("/track")
                                .content(inputTrack1Json)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputTrack1Json));
    }

    @Test
    public void shouldUpdateTrack()throws Exception {

        inputTrack1.setAlbumId(7);
    

        String inputJson = mapper.writeValueAsString(inputTrack1);

        mockMvc.perform(put("/track")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetTrackById()throws Exception {

        doReturn(Optional.of(outputTrack2)).when(repository).findById(2);

        mockMvc.perform(get("/track/2"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputTrack2Json));

    }

    @Test
    public void shouldDeleteTrack()throws Exception {

        mockMvc.perform(delete("/track/3"))
                .andExpect(status().isNoContent());

    }

    @Test
    public void shouldGetAllTheTracks() throws Exception{

        doReturn(outputTrackList).when(repository).findAll();

        mockMvc.perform(get("/track"))
                .andExpect(content().json(outputTrackListJson))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnTrackByTitle()throws Exception {

        List<Track> trackList = new ArrayList<>();

        trackList.add(outputTrack3);

        String outputJson = mapper.writeValueAsString(trackList);

        doReturn(trackList).when(repository).findByTitle("Lover");

        mockMvc.perform(get("/track/title/Lover"))
                .andExpect(content().json(outputJson))
                .andExpect(status().isOk());

    }

    }