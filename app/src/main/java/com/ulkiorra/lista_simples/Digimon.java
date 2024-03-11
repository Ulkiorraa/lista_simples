package com.ulkiorra.lista_simples;

public class Digimon {
    private String name;
    private int imageResourceId;
    private String description;

    public Digimon(String name, int imageResourceId, String description) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.description = description;
    }

    // Getters
    public String getName() { return name; }
    public int getImageResourceId() { return imageResourceId; }
    public String getDescription() { return description; }
}

