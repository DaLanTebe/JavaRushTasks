package org.example.task3212ServiceLocator;

public class EJBServiceImpl implements Service {

    @Override
    public void execute() {
        System.out.println("Executing the EJBService");
    }

    @Override
    public String getName() {
        return "EJBService";
    }

}
