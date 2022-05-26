package ru.netology.game;

public class Registered extends Exception {
    public Registered(int id) {
        super("Пользователь " + id + " уже существует");
    }
}