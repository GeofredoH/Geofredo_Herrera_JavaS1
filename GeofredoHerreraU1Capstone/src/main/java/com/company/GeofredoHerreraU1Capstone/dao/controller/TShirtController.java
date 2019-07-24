package com.company.GeofredoHerreraU1Capstone.dao.controller;

import com.company.GeofredoHerreraU1Capstone.dao.Exception.NotFoundException;
import com.company.GeofredoHerreraU1Capstone.dao.service.ServiceLayer;
import com.company.GeofredoHerreraU1Capstone.dao.viewModel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tshirt")
public class TShirtController {

    @Autowired
    ServiceLayer service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TShirtViewModel createTShirt(@RequestBody @Valid TShirtViewModel tShirtViewModel) {
        tShirtViewModel = service.createTShirt(tShirtViewModel);
        return tShirtViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTShirt(@PathVariable("id") int tShirtId) {
        TShirtViewModel tShirtViewModel = service.getTShirtViewModel(tShirtId);
        if (tShirtViewModel == null) {
            throw new NotFoundException("T-Shirt could not be retrieved for id " + tShirtId);
        } else {
            return tShirtViewModel;
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTShirt(@PathVariable("id") int tShirtId, @RequestBody @Valid TShirtViewModel tShirtViewModel) {
        if (tShirtViewModel.gettShirtId() == 0) {
            tShirtViewModel.settShirtId(tShirtId);
        } else if (tShirtId != tShirtViewModel.gettShirtId()) {
            throw new IllegalArgumentException("Id in path must match id in view model");
        }
        service.updateTShirtViewModel(tShirtViewModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable("id") int tShirtId) {
        service.deleteTShirtViewModel(tShirtId);
    }

    @GetMapping("/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsBySize(@PathVariable("size") String size) {
        List<TShirtViewModel> tvmBySize = service.getTShirtViewModelBySize(size);
        if (tvmBySize == null || tvmBySize.isEmpty()) {
            throw new NotFoundException("No t-shirts were found in size " + size);
        }
        return tvmBySize;
    }

    @GetMapping("/color/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getTShirtsByColor(@PathVariable("color") String color) {
        List<TShirtViewModel> tvmByColor = service.getTShirtViewModelByColor(color);
        if (tvmByColor == null || tvmByColor.isEmpty()) {
            throw new NotFoundException("No t-shirts were found in " + color);
        }
        return tvmByColor;
    }

}
