package ru.deathcry.bigbobby.b_theory.question11;

public class Nr5isD {

    //todo this is a contribution based question so make sure to keep commits separate
    //todo A What does D stand for in SOLID? Explain the principle.
    //todo B Give an example. Write actual or pseudo code.

}
// By Sergei Saal

// D - Dependency Inversion Principle

// Robert C. Martin describes it as it depends on abstractions not on concretions.
// According to it, the high-level module must never rely on any low-level module.

// Example of BAD code that DOES NOT follow Dependency Inversion Principle
class Employee {
    private Address address;
    private int salary;

    // In this case Employee depends on Address
    // If the Address class constructor is changed, then this class must be edited too
    public Employee(String country, String street, String postalCode, int salary) {
        this.address = new Address(country, street, postalCode);
        this.salary = salary;
    }
}

// Example of GOOD code that DOES follow Dependency Inversion Principle
class Worker {
    private Address address;
    private int salary;

    // In this case Employee don't depend on Address
    // Changes in Address class constructor do not have any impact on Worker
    public Worker(Address address, int salary) {
        this.address = address;
        this.salary = salary;
    }
}


// Just for compiler
class Address{
    private String country;
    private String street;
    private String postalCode;

    public Address(String country, String street, String postalCode) {
        this.country = country;
        this.street = street;
        this.postalCode = postalCode;
    }
    public String getCountry() { return country; }

    public String getStreet() { return street; }

    public String getPostalCode() { return postalCode; }
}