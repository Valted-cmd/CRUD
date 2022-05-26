package ru.netology.game;

import ru.netology.game.Registered;
import ru.netology.player.NotRegistered;
import ru.netology.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> listOfPlayers = new ArrayList<>();

    public void register(Player player) throws Registered {
        if (!listOfPlayers.contains(player)) {
            listOfPlayers.add(player);
        } else {
            throw new Registered(player.getId());
        }
    }

    public String getPlayers() {
        return listOfPlayers.toString();
    }

    public int round(String playerName1, String playerName2) throws NotRegistered {
        int result = 0;

        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            result = 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            result = 2;
        }

        return result;
    }

    private Player findByName(String playerName) throws NotRegistered {

        for (Player player : listOfPlayers) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        throw new NotRegistered(playerName);
    }
}