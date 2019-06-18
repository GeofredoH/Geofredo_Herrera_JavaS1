package com.company;

import java.util.*;
//import java.util.List;


public class App {
    public void printKeys(Map<String, String> passedMap) {

        Set<String> myKeys = passedMap.keySet();

        Iterator<String> iter = myKeys.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public void printValues(Map<String, String> passedMap) {
        Collection<String> myValues = passedMap.values();

        Iterator<String> iter = myValues.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public void printKeysAndValues(Map<String, String> passedMap) {
        Set<Map.Entry<String, String>> myEntries = passedMap.entrySet();
        for (Map.Entry<String, String> entry : myEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map mapFun(Map<String, Integer> passedMap) {
        passedMap.put("Ford Explorer", 2012);
        passedMap.put("Smart Fortwo", 2013);

        passedMap.remove("Jeep Wrangler");

        return passedMap;
    }

    public Map listCars(List<Car> newCar) {
        List<Car> toyotaList = new ArrayList<>();
        List<Car> fordList = new ArrayList<>();
        List<Car> hondaList = new ArrayList<>();

        for (Car checkCar : newCar) {
            if (checkCar.getMake().equals("Ford")) {
                fordList.add(checkCar);
            } else if (checkCar.getMake().equals("Toyota")) {
                toyotaList.add(checkCar);
            } else {
                hondaList.add(checkCar);
            }
        }

        Map<String, List<Car>> finalList = new HashMap<>();
        finalList.put("Toyota", toyotaList);
        finalList.put("Ford", fordList);
        finalList.put("Honda", hondaList);

        return finalList;
    }

}
