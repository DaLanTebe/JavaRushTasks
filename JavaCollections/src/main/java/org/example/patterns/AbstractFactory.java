package org.example.patterns;

public class AbstractFactory {
    public interface CarsFactory {
        Sedan createSedan();
        Coupe createCoupe();
    }

    public class ToyotaFactory implements CarsFactory {
        @Override
        public Sedan createSedan() {
            return new  ToyotaSedan();
        }

        @Override
        public Coupe createCoupe() {
            return new ToyotaCoupe();
        }
    }

    public class FordFactory implements CarsFactory {
        @Override
        public Sedan createSedan() {
            return new  FordSedan();
        }

        @Override
        public Coupe createCoupe() {
            return new FordCoupe();
        }
    }
    public interface Sedan {}

    public interface Coupe {}

    public class ToyotaCoupe implements Coupe {
        public ToyotaCoupe() {
            System.out.println("Create ToyotaCoupe");
        }
    }

    public class ToyotaSedan implements Sedan {
        public ToyotaSedan() {
            System.out.println("Create ToyotaSedan");
        }
    }

    public class FordCoupe implements Coupe {
        public FordCoupe () {
            System.out.println("Create FordCoupe");
        }
    }

    public class FordSedan implements Sedan {
        public FordSedan() {
            System.out.println("Create FordSedan");
        }
    }
}
