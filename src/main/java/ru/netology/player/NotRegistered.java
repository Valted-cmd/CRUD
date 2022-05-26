package ru.netology.player;

public class NotRegistered extends Exception {
    public NotRegistered(String name) {
        super("Пользователь " + name + " не зарегистрирован!");
    }
}