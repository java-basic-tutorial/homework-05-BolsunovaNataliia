package com.softserveinc.task02;

import java.util.*;
import java.util.stream.Collectors;

public class Task02 {

    final static Collection<Employee> EMPLOYEES = Arrays.asList(
            new Employee("Jon", 16, Gender.MAN),
            new Employee("Bob", 23, Gender.MAN),
            new Employee("Susanna", 18, Gender.WOMEN),
            new Employee("Nicola", 65, Gender.MAN),
            new Employee("Alex", 25, Gender.MAN),
            new Employee("Andrea", 21, Gender.WOMEN),
            new Employee("Jack", 33, Gender.MAN),
            new Employee("Andrea", 42, Gender.WOMEN),
            new Employee("Bill", 69, Gender.MAN)
    );

    static List<Employee> ex01() {
        // TODO: find and return list of all male employee with aged 18 to 27 (inclusive)
        List<Employee> boys = EMPLOYEES.stream()
            .filter(line -> line.getGender() == Gender.MAN)
            .filter(line -> line.getAge() >= 18 && line.getAge() <= 27)
        .collect(Collectors.toCollection(() -> new LinkedList<>()));
        return boys;
    }

static double ex02() {
        // TODO: compute the average age of all male
    List<Employee> men = EMPLOYEES.stream()
            .filter(line -> line.getGender() == Gender.MAN)
        .collect(Collectors.toCollection(() -> new LinkedList<>()));
        OptionalDouble average = men.stream().mapToInt(Employee::getAge).average();
        if(average.isPresent()) {
            return average.getAsDouble();
        }
        return 0;
    }

    static long ex03() {
        // TODO: count how many employees are male aged 18 to 60 and women aged 18 to 55
        List<Employee> men = EMPLOYEES.stream()
                .filter(line -> line.getGender() == Gender.MAN)
                .filter(line -> line.getAge() >= 18 && line.getAge() <= 60)
                .collect(Collectors.toCollection(() -> new LinkedList<>()));
        List<Employee> women = EMPLOYEES.stream()
                .filter(line -> line.getGender() == Gender.MAN)
                .filter(line -> line.getAge() >= 18 && line.getAge() <= 55)
                .collect(Collectors.toCollection(() -> new LinkedList<>()));
        long count = men.stream().count() + women.stream().count();
        return count;
    }

    static List<Employee> ex04() {
        // TODO: return the list of employees was sort employee by name in descending order
        List<Employee> descOrder = EMPLOYEES.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .collect(Collectors.toCollection(() -> new LinkedList<>()));
        return descOrder;
    }

    static OptionalInt ex05() {
        // TODO: find and return the oldest employee
        OptionalInt maxAge = EMPLOYEES.stream()
                .mapToInt(Employee::getAge).max();
        return maxAge;
    }

    static Optional<Employee> ex06() {
        // TODO: find and return the youngest employee
        Optional<Employee> youngest = EMPLOYEES.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .findFirst();
        return youngest;
    }

    public static void main(String[] args) {
        // TODO: you can check your solution here
        System.out.println("ex01() = " + ex01());
        System.out.println("ex02() = " + ex02());
        System.out.println("ex03() = " + ex03());
        System.out.println("ex04() = " + ex04());
        System.out.println("ex05() = " + ex05());
        System.out.println("ex06() = " + ex06());
    }
} 
