package com.company.GeofredoHerreraU1Capstone.dao.dao;

import com.company.GeofredoHerreraU1Capstone.dao.dto.Console;

import java.util.List;

public interface ConsoleDao {

    Console addConsole(Console console);

    Console getConsoleById(int id);

    List<Console> getAllConsoles();

    void updateConsole(Console console);

    void deleteConsoleById(int id);

    List<Console> getConsoleByManufacturer(String manufacturer);

}
