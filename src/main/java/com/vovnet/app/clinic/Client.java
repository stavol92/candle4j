package com.vovnet.app.clinic;

/**
 * Created by Vladimir on 15.12.2015.
 *
 *
 */
public class Client {

    private String id;
    private Pet pet;

    /**
     * Constructor
     * @param id    client's id
     * @param pet   client's pet
     */
    public Client(String id, Pet pet) {
        this.id = id;
        this.pet = pet;
    }

    /**
     * Get the pet
     * @return pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Set the pet
     * @param pet Pet
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * Remove the pet
     */
    public void removePet() {
        this.pet = null;
    }

    /**
     * Getter for id
     * @return client's id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter for id
     * @param id client's id
     */
    public void setId(String id) {
        this.id = id;
    }
}
