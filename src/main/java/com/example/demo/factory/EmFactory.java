package com.example.demo.factory;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmFactory {
    private final EntityManagerFactory emf;
    private static EmFactory instance = null;

    public EmFactory() {
        emf = Persistence.createEntityManagerFactory("kuga");
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public static EmFactory getInstance() {
        if (instance == null) {
            instance = new EmFactory();
        }
        return instance;
    }
}
