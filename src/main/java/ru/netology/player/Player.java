package ru.netology.player;

public class Player {
    private int id;
    private String name;
    private int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj instanceof Player) {
            Player o = (Player) obj;
            result = (id == o.id) || (name.equals(o.name));
        }

        return result;
    }
}