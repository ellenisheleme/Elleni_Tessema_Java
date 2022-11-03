package com.gamestorecatalog.gamestoreCatalog.controller;

import com.gamestorecatalog.gamestoreCatalog.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.gamestorecatalog.gamestoreCatalog.model.Console;

import javax.validation.Valid;


import java.util.List;
import java.util.Optional;

@RestController
@RefreshScope
@CrossOrigin(origins = {"http://localhost:3000"})
public class ConsoleController {

    @Autowired
    ConsoleRepository consoleRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console) {
       return consoleRepository.save(console);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Console getConsole(@PathVariable("id") long consoleId) {
        Optional<Console> consoleOptional = consoleRepository.findById(consoleId);

        if (!consoleOptional.isPresent()) {
            throw new IllegalArgumentException("Console could not be retrieved for id " + consoleId);
        } else {
            return consoleOptional.get();
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody @Valid Console console) {

        if (console==null || console.getId() < 1) {
            throw new IllegalArgumentException("Id in path must match id in view model");
        } else if (console.getId() > 0) {
           consoleRepository.save(console);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("id") long consoleId) {
        consoleRepository.deleteById(consoleId);
    }

    @GetMapping("/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getConsoleByManufacturer(@PathVariable("manufacturer") String manu) {
        List<Console> cvmByManufacturer = consoleRepository.findAllByManufacturer(manu);
        if (cvmByManufacturer == null || cvmByManufacturer.isEmpty()) {
            throw new IllegalArgumentException("No consoles, manufactured by " + manu + ", were found");
        } else
            return cvmByManufacturer;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Console> getAllConsoles() {
        List<Console> cByManufacturer = consoleRepository.findAll();
        if (cByManufacturer == null || cByManufacturer.isEmpty()) {
            throw new IllegalArgumentException("No consoles were found");
        } else
            return cByManufacturer;
    }
}
