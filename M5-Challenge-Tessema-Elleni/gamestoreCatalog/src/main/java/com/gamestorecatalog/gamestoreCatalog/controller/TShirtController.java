package com.gamestorecatalog.gamestoreCatalog.controller;
import com.gamestorecatalog.gamestoreCatalog.model.TShirt;
import com.gamestorecatalog.gamestoreCatalog.repository.TShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tshirt")
@CrossOrigin(origins = {"http://localhost:3000"})
@RefreshScope
public class TShirtController {
    @Autowired
    TShirtRepository tShirtRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TShirt createTShirt(@RequestBody @Valid TShirt tShirt) {
        tShirt = tShirtRepository.save(tShirt);
        return tShirt;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirt getTShirt(@PathVariable("id") Long tShirtId) {
        Optional<TShirt>optionalTShirt = tShirtRepository.findById(tShirtId);

        if(!optionalTShirt.isPresent()) {
            throw new IllegalArgumentException("T-Shirt could not be retrieved for id " + tShirtId);
        } else {
            return optionalTShirt.get();
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@RequestBody @Valid TShirt tShirt) {
        if (tShirt==null || tShirt.getId() < 1) {
            throw new IllegalArgumentException("Id in path must match id in view model");
        }else if (tShirt.getId() > 0) {
            tShirtRepository.save(tShirt);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable("id") long tShirtId) {
        Optional<TShirt>optionalTShirt= tShirtRepository.findById(tShirtId);
        if(optionalTShirt.isPresent()){
            deleteTShirt(optionalTShirt.get().getId());
            }
        }



    @GetMapping("/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getTShirtsBySize(@PathVariable("size") String size) {
        List<TShirt> tBySize = tShirtRepository.findAllBySize(size);
        if (tBySize == null || tBySize.isEmpty()) {
            throw new IllegalArgumentException("No t-shirts were found in size " + size);
        }
        return tBySize;
    }

    @GetMapping("/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getTShirtsByColor(@PathVariable("color") String color) {
        List<TShirt> tByColor = tShirtRepository.findAllByColor(color);
        if (tByColor == null || tByColor.isEmpty()) {
            throw new IllegalArgumentException("No t-shirts were found in " + color);
        }
        return tByColor;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TShirt> getAllTShirts() {
        List<TShirt> tShirtList = tShirtRepository.findAll();
        if (tShirtList == null || tShirtList.isEmpty()) {
            throw new IllegalArgumentException("No t-shirts were found.");
        }
        return tShirtList;
    }

}
