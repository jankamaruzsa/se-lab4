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
        assertEquals(true, result);
    }

    @Test
    void fire_Failure_Rate() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 1.0);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertFalse(result);
        assertEquals(1, store.getTorpedoCount());
    }

    @Test
    void fire_Exception_WhenEmpty() {
        // Arrange
        TorpedoStore store = new TorpedoStore(0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(1);
        });
    }

    @Test
    void isEmpty_InitiallyEmpty() {
        // Arrange & Act
        TorpedoStore store = new TorpedoStore(0);

        // Assert
        assertTrue(store.isEmpty());
        assertEquals(0, store.getTorpedoCount());
    }

    @Test
    void isEmpty_NotEmptyWhenStocked() {
        // Arrange & Act
        TorpedoStore store = new TorpedoStore(5);

        // Assert
        assertFalse(store.isEmpty());
        assertEquals(5, store.getTorpedoCount());
    }
}
