package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Poll", 45, "poll@pocket.com");
        person.setName("Polly");
        String name = person.getName();
        System.out.println("Name: " + name);

        person.setAge(30);
        int age = person.getAge();
        System.out.println("Age: " + age);

        person.setEmail("polly@pocket.com");
        String email = person.getEmail();
        System.out.println("Email: " + email);
    }
}