package com.dakshay;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        LogFileProcessor logFileProcessor = new LogFileProcessor();
        logFileProcessor.prepareData("file1.txt");
        logFileProcessor.prepareData("file2.txt");
        List<String> loyal = logFileProcessor.loyalCustomers();
        System.out.println("Loyal Customers are :");
        loyal.forEach(l-> System.out.print(l + ", "));
    }





}