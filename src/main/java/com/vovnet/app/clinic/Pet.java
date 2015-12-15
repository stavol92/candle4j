package com.vovnet.app.clinic;

/**
 * Created by Vladimir on 15.12.2015.
 *
 * Pet
 */
public interface Pet {
    /**
     * Make a sound
     */
    void makeSound();

    /**
     * Get a pet's name
     * @return name of pet
     */
    String getName();

    /**
     * Set name of pet
     * @param name  name of pet
     */
    void setName(final String name);
}
