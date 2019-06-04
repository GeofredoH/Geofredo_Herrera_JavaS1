package com.company;

import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {
        double width = 0;
        double length = 0;
        double area = 0;
        double perimeter = 0;
        double subTotalCement = 0;
        double subTotalFooter = 0;

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter the width");
        width = myScanner.nextDouble();

        System.out.println("Enter the length");
        length = myScanner.nextDouble();

        System.out.println("Enter the price of cement");
        double cementPrice = myScanner.nextDouble();


        System.out.println("Enter the price of frame/footers");
        double footerPrice = myScanner.nextDouble();

        area = length * width;
        perimeter = (length * 2) + (width * 2);

        subTotalCement = area * cementPrice;
        subTotalFooter = perimeter * footerPrice;


        System.out.println("The area is " + area + " sq. ft.");
        System.out.println("The perimeter is " + perimeter + " ft.");
        System.out.format("Subtotal for cement $%.2f \n", subTotalCement);
        System.out.format("Subtotal for frame/footers $%.2f", subTotalFooter);




    }
}
