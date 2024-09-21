package org.example.Patterns.Factory;

public class Factory {

    public static AbstractPerson createPerson (PersonType type) throws Exception {
        switch (type){
            case WARRIOR: return new Warrior();
            case ARCHER: return new Archer();
                default:
                    throw new Exception();
        }
    }
}
