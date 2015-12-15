package com.vovnet.app.clinic;

import java.util.Scanner;

/**
 * Created by Vladimir on 15.12.2015.
 *
 * Runner the clinic
 */
public class Runner {

    private static final int MAX_CLIENTS = 10;

    private Scanner scanner;
    private Clinic clinic;
    private boolean isExit;
    private Client currentClient;

    public static void main(String[] args) {
        Runner runner = new Runner();
    }

    /**
     * Constructor
     */
    public Runner() {
        init();
        addTestClients();
        work();
    }

    /**
     * Start working
     */
    private void work() {
        while (!isExit) {
            showMenu();
            processInput();
        }
        scanner.close();
    }

    /**
     * Initialize clinic
     */
    private void init() {
        this.clinic = new Clinic(MAX_CLIENTS);
        scanner = new Scanner(System.in);
        isExit = false;
    }

    /**
     * Add test clients
     */
    private void addTestClients() {
        clinic.addClient(0, new Client("Vasya", new Cat("Pushok")));
        clinic.addClient(1, new Client("Petya", new Cat("Rizhik")));
        clinic.addClient(2, new Client("Nastya", new Dog("Sharik")));
        clinic.addClient(3, new Client("Ivan", new Cat("Sharik")));
    }

    /**
     * Processing user's input
     */
    private void processInput() {
        int select = 0;
        // validate
        try {
            select = Integer.valueOf(this.scanner.next());
        } catch (NumberFormatException ex) {        }

        switch (select) {
            case 1:
                addNewClientAction();
                break;
            case 2:
                removeClientAction();
                break;
            case 3:
                editClientAction();
                break;
            case 4:
                showAllClientsAction();
                break;
            case 5:
                isExit = true;
                break;
            default:
                System.out.println("\tIncorrect action, please repeat!");
                break;
        }
    }

    /**
     * Prints the menu (actions)
     */
    private void showMenu() {
        System.out.println("============================");
        System.out.println("Select action:");
        System.out.println("\t1. Add a new client.");
        System.out.println("\t2. Remove a client.");
        System.out.println("\t3. Edit a client.");
        System.out.println("\t4. Show all clients.");
        System.out.println("\t5. Exit.");
        System.out.println("============================");
    }

    /**
     * Show all clients with their pets
     */
    private void showAllClientsAction() {
        Client[] clients = this.clinic.getClients();
        System.out.println("List of clients:");
        for (Client client : clients) {
            if (client != null) {
                Pet pet = client.getPet();
                System.out.print("\tClient: " + client.getId());
                if (pet != null) {
                    System.out.println(", pet: " + pet.getName() + " (" + pet.getClass().getSimpleName() + ")");
                } else {
                    System.out.println();
                }
            }
        }
    }

    /**
     * Edit the data of client
     */
    private void editClientAction() {
        this.currentClient = null;
        System.out.println("Enter client's id:");
        String clientId = this.scanner.next();
        searchClient(clientId);
        if (this.currentClient != null) {
            System.out.println("Enter new name of client:");
            this.currentClient.setId(scanner.next());
            Pet pet = requestNewPet();
            this.currentClient.setPet(pet);
        }
    }

    /**
     * Search client
     * @param clientId id of client
     */
    private void searchClient(String clientId) {
        Client[] searchedClients = this.clinic.findClientById(clientId);
        for (Client client : searchedClients) {
            if (client.getId().equals(clientId)) {
                this.currentClient = client;
            }
        }
    }

    /**
     * Remove client
     */
    private void removeClientAction() {
        System.out.println("Enter the client's id you want to remove:");
        String clientId = this.scanner.next();
        this.clinic.removeClient(clientId);
    }

    /**
     * Add new client
     */
    private void addNewClientAction() {
        System.out.println("Input the client ID:");
        String clientId = scanner.next();
        Pet pet = requestNewPet();
        int numClients = clinic.numberOfClients();
        if (numClients == MAX_CLIENTS) {
            numClients--;
        }
        this.clinic.addClient(numClients, new Client(clientId, pet));
        System.out.println("Client was added.");
    }

    /**
     * Request the user create new pet
     * @return Pet
     */
    private Pet requestNewPet() {
        System.out.println("Input the pet's class (dog, cat...):");
        String petClass = scanner.next();
        while (!petClass.equals("dog") && !petClass.equals("cat")) {
            System.out.println("Wrong pet's class, please input the correct class (dog, cat...):");
            petClass = scanner.next();
        }
        System.out.println("Input pet's name:");
        String petName = scanner.next();
        Pet pet = null;
        if (petClass.equals("dog")) {
            pet = new Dog(petName);
        } else if (petClass.equals("cat")) {
            pet = new Cat(petName);
        }
        return pet;
    }
}
