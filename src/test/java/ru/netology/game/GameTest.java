package ru.netology.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.player.NotRegistered;
import ru.netology.player.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {
    Player player1 = new Player(1, "birdie", 100);
    Player player2 = new Player(2, "doggy", 98);
    Player player3 = new Player(3, "kitten", 100);
    Game game = new Game();

    @BeforeEach
    public void registerPlayers() throws Registered {
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    public void shouldRegister() {
        String expected = "[birdie, doggy, kitten]";
        String actual = game.getPlayers();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldRegisterRegisteredPlayer() {

        assertThrows(Registered.class, () -> {
            game.register(new Player(1, "BANAN", 100));
        });
    }

    @Test
    public void shouldWinIfEqual() throws Exception{
        int expected = 0;
        int actual = game.round("birdie", "kitten");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWinIfLarger() throws Exception{
        int expected = 1;
        int actual = game.round("birdie", "doggy");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWinIfSmaller() throws Exception{
        int expected = 2;
        int actual = game.round("doggy", "birdie");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldWinIfNotRegistered(){

        assertThrows(NotRegistered.class, () -> {
            game.round("doggy", "kryaka");
        });
    }

}