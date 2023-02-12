package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
	 Factory factory1 = new Factory("Factory1");
     Sweets sweets1 = new Sweets(1,"Chocolate", LocalDate.now(),1,300,SweetsType.CHOCOLATE);
     Sweets sweets2 = new Sweets(2,"Waffle", LocalDate.of(2020,11,22),2,200,SweetsType.WAFFLE);
     Sweets sweets3 = new Sweets(3,"Bisquits", LocalDate.of(2021,1,12),3,200,SweetsType.BISQUITS);

     factory1.addSweet(sweets1);
     factory1.addSweet(sweets3);
     factory1.addSweet(sweets2);
     factory1.addSweet(sweets3);

     factory1.displaySweets();
     //factory1.removeAllSweets();

     System.out.println("-------- task 2 -----------------------------");

     factory1.setMarkups();
     factory1.displaySweetTypesAndMarkup();
     factory1.sortBySweetsType();
     factory1.showSweetsAboveMarkup10();

     System.out.println("-------- task 3 -----------------------------");

     factory1.fillSetOfSweets();
     factory1.showSweetsAboveQuantity();
     factory1.showChocolate();
     factory1.sortByPriceDecs();
     factory1.sortBySweetsDateAndName();

    }
}
