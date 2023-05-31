package com.javarush.task.jdk13.task41.task4103.blood;

import com.javarush.task.jdk13.task41.task4103.security.SecuritySystem;

import java.util.*;

public class BloodDBProxy implements DB{
    private final SecuritySystem security;
    private BloodDB db;
    private final BloodSample denied = new BloodSample(0, "access", "denied", null, null, null);

    public BloodDBProxy() {
        security = new SecuritySystem();
        Scanner console = new Scanner(System.in);
        String login = console.nextLine();
        String password = console.nextLine();
        security.authorize(login, password);
        if (security.isAuthorized()){
            db = new BloodDB();
        }
    }

    @Override
    public BloodSample getById(int id) {
        if (security.isAuthorized()){
           return db.getById(id);
        }
        return denied;
    }

    @Override
    public List<BloodSample> find(String request) {
        if (security.isAuthorized()){
            db.find(request);
        }
        return List.of(denied);
    }
}
