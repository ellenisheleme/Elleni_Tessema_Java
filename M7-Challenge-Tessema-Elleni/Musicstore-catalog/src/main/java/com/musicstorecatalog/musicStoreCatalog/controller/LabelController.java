package com.musicstorecatalog.musicStoreCatalog.controller;

import com.musicstorecatalog.musicStoreCatalog.model.Label;
import com.musicstorecatalog.musicStoreCatalog.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    LabelRepository labelRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Label> getAllLabels(){
        return labelRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Label getAlabel(@PathVariable int id) {
        Optional<Label>optionalLable = labelRepository.findById(id);
        if(optionalLable.isPresent()){
            return optionalLable.get();
        }else{
            return null;
        }
    }
    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Label> getLabelByName(@PathVariable String name){
        return labelRepository.findByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Label createAnewLabel(@RequestBody @Valid Label label){
        return labelRepository.save(label);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlabel(@RequestBody @Valid Label label){
         labelRepository.save(label);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlabel(@PathVariable int id){
        labelRepository.deleteById(id);
    }
}
