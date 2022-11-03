package com.gameStoreInvoicing.gamestoreinvoicing.service;

import com.gameStoreInvoicing.gamestoreinvoicing.viewModel.ConsoleViewModel;
import com.gameStoreInvoicing.gamestoreinvoicing.viewModel.GameViewModel;
import com.gameStoreInvoicing.gamestoreinvoicing.viewModel.TShirtViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "gameStoreCatalog")
public interface GameStoreFeignClient {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") Long consoleId);

    @GetMapping("/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable("manufacturer") String manu);

    @GetMapping("/console")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles();

     @PostMapping("/console")
     @ResponseStatus(HttpStatus.CREATED)
     public ConsoleViewModel createConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel);


     @PostMapping("/game")
     @ResponseStatus(HttpStatus.CREATED)
     public GameViewModel createGame(@RequestBody @Valid GameViewModel gameViewModel);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGameInfo(@PathVariable("id") Long gameId);

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable("title") String title);

    @GetMapping("/esrbrating/{esrb}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByEsrbRating(@PathVariable("esrb") String esrb);

    @GetMapping("/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable("studio") String studio);

    @GetMapping("/game")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getAllGames();

     @PutMapping("/game")
     @ResponseStatus(HttpStatus.NO_CONTENT)
     public void updateGame(@RequestBody @Valid GameViewModel gameViewModel);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable("id") Long tShirtId);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable("id") int tShirtId);

    @GetMapping("/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsBySize(@PathVariable("size") String size);

    @GetMapping("/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsByColor(@PathVariable("color") String color);


    @GetMapping("/tshirt")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getAllTShirts();

   

}