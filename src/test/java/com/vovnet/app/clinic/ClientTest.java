package com.vovnet.app.clinic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vladimir on 15.12.2015.
 *
 * Test Client.java class
 */
public class ClientTest {

    private Client client;

    @Before
    public void setUp() throws Exception {
        this.client = new Client("Bob", new Dog("Doggy"));
    }

    @Test
    public void testGetPet() throws Exception {
        assertEquals("Doggy", this.client.getPet().getName());
    }

    @Test(expected = NullPointerException.class)
    public void testRemovePet() throws Exception {
        this.client.removePet();
        this.client.getPet().getName();
    }

    @Test
    public void testGetId() throws Exception {
        assertEquals("Bob", this.client.getId());
    }

    @Test
    public void testSetId() throws Exception {
        String newId = "Mike";
        this.client.setId(newId);
        assertEquals(newId, this.client.getId());
    }
}