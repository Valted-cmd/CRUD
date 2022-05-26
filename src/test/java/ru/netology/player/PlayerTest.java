package ru.netology.player;

import org.junit.jupiter.api.Test;
import ru.netology.player.Player;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player = new Player(4, "Pyos", 100);

    @Test
    public void shouldEqualIfIdAndNameSame() {

        assertTrue(player.equals(new Player(4, "Pyos", 140)));
    }

    @Test
    public void shouldEqualIfIdSame() {

        assertTrue(player.equals(new Player(4, "Ananas", 140)));
    }

    @Test
    public void shouldEqualIfNameSame() {

        assertTrue(player.equals(new Player(6, "Pyos", 140)));
    }

    @Test
    public void shouldEqualIfDiffers() {

        assertFalse(player.equals(new Player(2, "Ananas", 140)));
    }

    @Test
    public void shouldEqualIfNotPlayer() {
        assertFalse(player.equals(new Object()));
    }
}