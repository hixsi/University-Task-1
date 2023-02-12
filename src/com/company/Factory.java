package com.company;

import javax.swing.text.Position;
import java.util.*;
import java.util.stream.Stream;

public class Factory {
    private String name;
    private Deque<Sweets> sweets;
    private Map<SweetsType,Double> markups;
    private Set<Sweets> sweetsSet;

    public Factory(String name) {
        this.name = name;
        this.sweets = new ArrayDeque<>();
        this.markups = new EnumMap<>(SweetsType.class);
        this.sweetsSet = new TreeSet<>(Sweets.SweetsByRegNumber);
    }

    public String getName() {
        return name;
    }

    public Deque<Sweets> getSweets() {
        return sweets;
    }

    public void addSweet(Sweets sweet){
        sweets.add(sweet);
    }

    public void displaySweets() {
        if (sweets.isEmpty()) {
            System.out.println("There are no sweets. ");
        } else {
            System.out.println(sweets);
        }
    }
    public void setMarkup(SweetsType sweetsType, double markup) {

        markups.put(sweetsType, markup);
    }

    public void setMarkups() {
        double startMarkup = 2;
        for (SweetsType sweetsType: SweetsType.values()) {
            setMarkup(sweetsType, startMarkup += 5);
        }
    }

    public void displaySweetTypesAndMarkup() {
        markups.forEach((type,markup) -> System.out.println(type + " - " + markup));
    }

    public void removeSweet() {

        System.out.println(sweets.remove());
    }

    public void removeAllSweets() {
        if (sweets.isEmpty()) {
            System.out.println("There are no sweets. ");
        } else {
            for (Sweets sweet: this.sweets) {
                System.out.println(sweets.remove());
            }
        }
    }

    public  void sortBySweetsType(){


        List<Sweets> copySweetsList = new ArrayList<>(sweets);

        Collections.sort(copySweetsList,Sweets.SweetsByType);
        System.out.println(copySweetsList);
    }

    public void fillSetOfSweets(){
        for(Sweets sweet: sweets){
            if(!sweetsSet.contains(sweet)){
                sweetsSet.add(sweet);
                System.out.println(sweet);}
        }
    }

    public  void sortByPriceDecs(){


//        List<Sweets> copySweetsList = new ArrayList<>(sweetsSet);
//
//        Collections.sort(copySweetsList,Sweets.SweetsByPrice.reversed());
//        System.out.println(copySweetsList);
        Stream<Sweets> sweetsStream = sweetsSet.stream();

        sweetsStream.sorted(Sweets.SweetsByPrice.reversed()).forEach(System.out::println);
    }

    public  void sortBySweetsDateAndName(){


//        List<Sweets> copySweetsList = new ArrayList<>(sweetsSet);
//
//        Collections.sort(copySweetsList,Sweets.SweetsByDate.thenComparing(Sweets.SweetsByName));
//        System.out.println(copySweetsList);
        Stream<Sweets> sweetsStream = sweetsSet.stream();

        sweetsStream.sorted(Sweets.SweetsByDate.thenComparing(Sweets.SweetsByName)).forEach(System.out::println);
    }

    public void showChocolate(){
        Stream<Sweets> sweetsStream = sweetsSet.stream();
        sweetsStream.filter(sweet -> sweet.getSweetsType().equals(SweetsType.CHOCOLATE)).forEach(System.out::println);
    }

    public void showSweetsAboveQuantity(){
        Stream<Sweets> sweetsStream = sweetsSet.stream();
        sweetsStream.filter(sweet -> sweet.getProducedQuantity() > 200 ).forEach(System.out::println);

    }


   public void showSweetsAboveMarkup10(){

    for (Sweets sweet: this.sweets){
        if(markups.get(sweet.getSweetsType()) > 10)
            System.out.println(sweet);
    }
   }





}
