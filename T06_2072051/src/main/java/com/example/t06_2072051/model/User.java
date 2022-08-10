package com.example.t06_2072051.model;

public class User {
    private String Username;
    private String Komentar;

    public User(String username, String komentar) {
        Username = username;
        Komentar = komentar;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getKomentar() {
        return Komentar;
    }

    public void setKomentar(String komentar) {
        Komentar = komentar;
    }

    @Override
    public String toString() {
        return "User{" +
                "Username='" + Username + '\'' +
                ", Komentar='" + Komentar + '\'' +
                '}';
    }
}
