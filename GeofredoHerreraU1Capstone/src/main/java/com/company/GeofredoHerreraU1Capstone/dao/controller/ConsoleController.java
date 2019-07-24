package com.company.GeofredoHerreraU1Capstone.dao.controller;

import com.company.GeofredoHerreraU1Capstone.dao.Exception.NotFoundException;
import com.company.GeofredoHerreraU1Capstone.dao.service.ServiceLayer;
import com.company.GeofredoHerreraU1Capstone.dao.viewModel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/console")
public class ConsoleController {

    @Autowired
    ServiceLayer service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody @Valid ConsoleViewModel consoleViewModel) {
        consoleViewModel = service.createConsoleViewModel(consoleViewModel);
        return consoleViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") int consoleId) {
        ConsoleViewModel consoleViewModel = service.getConsoleViewModelById(consoleId);
        if (consoleViewModel == null) {
            throw new NotFoundException("Console could not be retrieved for id " + consoleId);
        } else {
            return consoleViewModel;
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable("id") int consoleId, @RequestBody @Valid ConsoleViewModel consoleViewModel) {

        if (consoleViewModel.getConsoleId() == 0) {
            consoleViewModel.setConsoleId(consoleId);
        } else if (consoleId != consoleViewModel.getConsoleId()) {
            throw new IllegalArgumentException("Id in path must match id in view model");
        }
        service.updateConsoleViewModel(consoleViewModel);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("id") int consoleId) {
        service.deleteConsoleViewModel(consoleId);
    }

    @GetMapping("/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable("manufacturer") String manu) {
        List<ConsoleViewModel> cvmByManufacturer = service.getConsoleViewModelByManufacturer(manu);
        if (cvmByManufacturer == null || cvmByManufacturer.isEmpty()) {
            throw new NotFoundException("No consoles, manufactured by " + manu + ", were found");
        } else
            return cvmByManufacturer;
    }
}
