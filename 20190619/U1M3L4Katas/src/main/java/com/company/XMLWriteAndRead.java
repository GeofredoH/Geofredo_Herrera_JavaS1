package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class XMLWriteAndRead {
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
            ObjectMapper mapper = new XmlMapper();
            String xmlVehicleList = mapper.writeValueAsString(carList);

            System.out.println(xmlVehicleList);

            writer = new PrintWriter(new FileWriter("cars.xml"));

            writer.println(xmlVehicleList);


            for (Car carVar : carList) {
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
