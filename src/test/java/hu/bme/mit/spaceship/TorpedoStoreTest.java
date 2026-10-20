package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertTrue(result);
        assertEquals(0, store.getTorpedoCount());
        assertTrue(store.isEmpty());
    }

    @Test
    void fire_Success_MultipleTorpedos() {
        TorpedoStore store = new TorpedoStore(3, 0.0);

        boolean result = store.fire(1);

        assertTrue(result);
        assertEquals(2, store.getTorpedoCount());
        assertFalse(store.isEmpty());
    }

    @Test
    void fire_Failure_Rate() {
        TorpedoStore store = new TorpedoStore(1, 1.0);

        boolean result = store.fire(1);

        assertFalse(result);
        assertEquals(1, store.getTorpedoCount());
    }

    @Test
    void fire_Exception_WhenEmpty() {
        TorpedoStore store = new TorpedoStore(0);

        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(1);
        });
    }

    @Test
    void fire_Exception_InvalidNumberOfTorpedos_Zero() {
        TorpedoStore store = new TorpedoStore(5);

        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(0);
        });
    }

    @Test
    void fire_Exception_InvalidNumberOfTorpedos_Negative() {
        TorpedoStore store = new TorpedoStore(5);

        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(-1);
        });
    }

    @Test
    void fire_Exception_TooManyTorpedos() {
        TorpedoStore store = new TorpedoStore(2);

        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(3);
        });
    }

    @Test
    void isEmpty_InitiallyEmpty() {
        TorpedoStore store = new TorpedoStore(0);

        assertTrue(store.isEmpty());
        assertEquals(0, store.getTorpedoCount());
    }

    @Test
    void isEmpty_NotEmptyWhenStocked() {
        TorpedoStore store = new TorpedoStore(5);

        assertFalse(store.isEmpty());
        assertEquals(5, store.getTorpedoCount());
    }

    @Test
    void constructor_ZeroFailureRate() {    
        TorpedoStore store = new TorpedoStore(10, 0.0);

        assertEquals(10, store.getTorpedoCount());
        assertFalse(store.isEmpty());
    }
}