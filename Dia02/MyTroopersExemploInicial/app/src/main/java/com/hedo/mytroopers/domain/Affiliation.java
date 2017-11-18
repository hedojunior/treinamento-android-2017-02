package com.hedo.mytroopers.domain;

/**
 * Criado por hedo.junior em 16/11/2017.
 */

public enum Affiliation {
    EMPIRE(0),
    REPUBLIC(1),
    FIRST_ORDER(2);

    Affiliation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private int value;
}
