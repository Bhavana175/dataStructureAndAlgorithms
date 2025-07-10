package lld.carrental.controller;

import lld.carrental.model.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarRentalController {
    HashMap<String, List<Store>> storeByLocation ;

    public CarRentalController() {
        this.storeByLocation = new HashMap<>();
    }

    public void addStore(String city, Store store){
       storeByLocation.computeIfAbsent(city, (k)->new ArrayList<>()).add(store);
    }

    public List<Store> storeList(String city){
        if(storeByLocation.containsKey(city)){
            return storeByLocation.get(city);
        }else return new ArrayList<>();
    }

   // void removeStore(){}



}
