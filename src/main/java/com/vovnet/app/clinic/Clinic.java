package com.vovnet.app.clinic;

/**
 * Created by Vladimir on 15.12.2015.
 *
 * Represent clinic for pets.
 */
public class Clinic {

    /**
     * List of clients
     */
    private final Client[] clients;

    /**
     * Constructor
     * @param size clinics size
     */
    public Clinic(final int size) {
        this.clients = new Client[size];
    }

    /**
     * Get all clients
     * @return clients
     */
    public Client[] getClients() {
        return clients;
    }

    /**
     * Add new client
     * @param position  were put the new client
     * @param client    client
     */
    public void addClient(final int position, final Client client) {
        this.clients[position] = client;
    }

    /**
     * Remove client by ID
     * @param id    client's id
     * @return      true, if client was remove
     */
    public boolean removeClient(final String id) {
        boolean isRemovedClient = false;
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getId().equals(id)) {
                this.clients[i] = null;
                isRemovedClient = true;
            }
        }
        return isRemovedClient;
    }

    /**
     * Counts the number of clients
     * @return number of clients
     */
    public int numberOfClients() {
        int counter = 0;
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Search all clients by pet's name
     * @param petName   name of pet
     * @return          array of clients
     */
    public Client[] findClientsByPetName(final String petName) {
        int numOfPets = 0;
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getPet() != null && this.clients[i].getPet().getName().equals(petName)) {
                numOfPets++;
            }
        }
        int counter = 0;
        Client[] result = new Client[numOfPets];
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getPet() != null && this.clients[i].getPet().getName().equals(petName)) {
                result[counter++] = this.clients[i];
            }
        }
        return result;
    }


    /**
     * Search clients by client's id
     * @param id    id of client
     * @return      all searched clients
     */
    public Client[] findClientById(final String id) {
        int numOfClients = 0;
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getId().equals(id)) {
                numOfClients++;
            }
        }
        Client[] result = new Client[numOfClients];
        int counter = 0;
        for (int i = 0; i < this.clients.length; i++) {
            if (this.clients[i] != null && this.clients[i].getId().equals(id)) {
                result[counter++] = this.clients[i];
            }
        }
        return result;
    }
}
