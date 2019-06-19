package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONWriteAndRead {
    public static void main(String[] args) {
        PrintWriter writer = null;

        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));


//        List<Car> vehicleList = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonVehicleList = mapper.writeValueAsString(carList);

            System.out.println(jsonVehicleList);

            writer = new PrintWriter(new FileWriter("cars.json"));

            writer.println(jsonVehicleList);

            ObjectMapper mapper2 = new ObjectMapper(); //for the sake of reading the values from json file

            List<Car> carList2;

            carList2 = mapper2.readValue(jsonVehicleList,
                    new TypeReference<List<Car>>() {
                    });


            for (Car carVar : carList2) {
                System.out.println("================");
                System.out.println(carVar.getMake());
                System.out.println(carVar.getModel());
                System.out.println(carVar.getYear());
                System.out.println(carVar.getColor());
            }

        } catch (JsonProcessingException e) {
            System.out.println("Error: Trouble converting object to JSON string" + e.getMessage());

        } catch (IOException e) {
            System.out.println("Error: Could not write to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
