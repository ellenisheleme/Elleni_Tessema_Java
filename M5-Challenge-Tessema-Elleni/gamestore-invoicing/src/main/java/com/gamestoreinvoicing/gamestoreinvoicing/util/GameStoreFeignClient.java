package com.gamestoreinvoicing.gamestoreinvoicing.util;


import com.gamestoreinvoicing.gamestoreinvoicing.viewModel.ConsoleViewModel;
import com.gamestoreinvoicing.gamestoreinvoicing.viewModel.GameViewModel;
import com.gamestoreinvoicing.gamestoreinvoicing.viewModel.TShirtViewModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "gameStoreCatalog")
public interface GameStoreFeignClient {

    @GetMapping("console/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") long consoleId);

    @GetMapping("console/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable("manufacturer") String manu);

    @GetMapping("/console")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles();
    @PutMapping("/console")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel);

    @GetMapping("game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("id") long gameId);

    @GetMapping("game/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByTitle(@PathVariable("title") String title);

    @GetMapping("game/esrbrating/{esrb}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByEsrbRating(@PathVariable("esrb") String esrb);

    @GetMapping("game/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGamesByStudio(@PathVariable("studio") String studio);

    @GetMapping("/game")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getAllGames();

    @PostMapping("/tshirt")
    @ResponseStatus(HttpStatus.CREATED)
    public TShirtViewModel createTShirt(@RequestBody @Valid TShirtViewModel tShirtViewModel);


    @GetMapping("tshirt/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable("id") long tShirtId);

    @GetMapping("tshirt/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsBySize(@PathVariable("size") String size);

    @GetMapping("tshirt/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsByColor(@PathVariable("color") String color);

    @GetMapping("/tshirt")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getAllTShirts();


    @PutMapping("game")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@RequestBody @Valid GameViewModel gameViewModel);

    @PutMapping("tshirt")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@RequestBody @Valid TShirtViewModel tShirtViewModel);



}