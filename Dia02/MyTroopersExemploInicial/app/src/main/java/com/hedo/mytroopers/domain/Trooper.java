package com.hedo.mytroopers.domain;

import java.io.Serializable;

/**
 * Criado por hedo.junior em 16/11/2017.
 */

public class Trooper implements Serializable {
    private Integer id;
    private String name;
    private String picture;
    private String description;
    private Affiliation affiliation;

    public Trooper(int id, String name, String picture, String description, Affiliation affiliation) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.affiliation = affiliation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public String getDescription() {
        return description;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    @Override
    public boolean equals(Object obj) {
        Trooper trooper = (Trooper) obj;
        return trooper.getId() == this.getId();
    }
}
