package com.company;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Sweets implements Comparable<Sweets> {

    private long regNumber;
    private String name;
    private LocalDate productionDate;
    private double productionPrice;
    private int producedQuantity;
    private SweetsType sweetsType;

    public Sweets(long regNumber, String name, LocalDate productionDate, double productionPrice, int producedQuantity,SweetsType sweetsType) {
        this.regNumber = regNumber;
        this.name = name;
        this.productionDate = productionDate;
        this.productionPrice = productionPrice;
        this.producedQuantity = producedQuantity;
        this.sweetsType = sweetsType;
    }

    @Override
    public String toString() {
        return "Sweets{" +
                "regNumber=" + regNumber +
                ", name='" + name + '\'' +
                ", productionDate=" + productionDate +
                ", productionPrice=" + productionPrice +
                ", producedQuantity=" + producedQuantity +
                '}';
    }

    public int getProducedQuantity() {
        return producedQuantity;
    }

    public SweetsType getSweetsType() {
        return sweetsType;
    }

    @Override
    public int compareTo(Sweets o) {
        return Integer.compare(this.producedQuantity,o.getProducedQuantity());
    }

    public static Comparator<Sweets> SweetsByType = (s1,s2) -> (Integer.compare(s1.sweetsType.getCode(),s2.sweetsType.getCode()));
    public static Comparator<Sweets> SweetsByPrice = (s1,s2) -> (Double.compare(s1.productionPrice,s2.productionPrice));
    public static Comparator<Sweets> SweetsByDate = (s1,s2) -> (s1.productionDate.compareTo(s2.productionDate));
    public static Comparator<Sweets> SweetsByName = (s1,s2) -> (s1.name.compareTo(s2.name));
    public static Comparator<Sweets> SweetsByRegNumber = (s1,s2) -> (Long.compare(s1.regNumber, s2.regNumber));


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweets sweets = (Sweets) o;
        return regNumber == sweets.regNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber);
    }
}
