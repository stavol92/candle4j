package com.vovnet.app.clinic;

/**
 * Created by Vladimir on 15.12.2015.
 *
 * The cat
 */
public class Cat implements Pet {

    /**
     * Name of pet
     */
    private String name;

    /**
     * Constructor
     * @param name name of pet
     */
    public Cat(final String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println("May...");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
