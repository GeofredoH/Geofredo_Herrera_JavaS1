package com.company;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.List;

public class ComputerReader {
    public static void main(String[] args) {

        try {
            List<Computer> comps = new CsvToBeanBuilder<Computer>(
                    new FileReader("computers.csv")).withType(Computer.class).build().parse();

            for (Computer pc : comps) {
                System.out.println("========================");
                System.out.println(pc.getBrand());
                System.out.println(pc.getModel());
                System.out.println(pc.getCpu());
                System.out.println(pc.getRam());
                System.out.println(pc.getStorageSize());

            }


        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
