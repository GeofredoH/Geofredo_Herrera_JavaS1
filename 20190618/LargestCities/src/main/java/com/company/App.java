package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        String city;
        int population;

        City ny = new City("New York", 8654321);
        City la = new City("Los Angeles", 4563218);
        City chi = new City("Chicago", 2716520);
        City den = new City("Denver", 704621);
        City dm = new City("Des Moines", 217521);
        City atl = new City("Atlanta", 486213);

        Map<String, City> myCities = new HashMap<>();

        myCities.put("New York", ny);
        myCities.put("California", la);
        myCities.put("Illinois", chi);
        myCities.put("Colorado", den);
        myCities.put("Iowa", dm);
        myCities.put("Georgia", atl);

        Set<Map.Entry<String, City>> myEntries = myCities.entrySet();
        for (Map.Entry<String, City> entry : myEntries) {
            System.out.println("State = " + entry.getKey() + " : City Name = " + entry.getValue().getName() + " : Population " + entry.getValue().getPopulation());
        }
    }
}
