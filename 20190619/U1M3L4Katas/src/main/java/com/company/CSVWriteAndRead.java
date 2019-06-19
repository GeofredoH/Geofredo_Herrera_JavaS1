package com.company;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVWriteAndRead {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));

        try {

            for (Car ride : carList) {
                Writer writer = new FileWriter("new_car.csv");
                StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
                beanToCsv.write(carList);
                writer.close();
            }

            List<Car> ride2 = new CsvToBeanBuilder<Car>(
                    new FileReader("new_car.csv")).withType(Car.class).build().parse();

            for (Car vehicle : ride2) {
                System.out.println("========================");
                System.out.println(vehicle.getYear());
                System.out.println(vehicle.getMake());
                System.out.println(vehicle.getModel());
                System.out.println(vehicle.getColor());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("Something went wrong with your csv file: " + e.getMessage());
        }
    }
}
