package org.example.patterns;

public class Singleton {

    private Singleton instance;

    public Singleton getInstance(){
        if (instance != null){
            instance = new Singleton();
        }
        return instance;
    }

    private Singleton(){

    }
}
