package antonionorfo;

import jakarta.persistence.EntityManagerFactory;

public class Application {
    private static final EntityManagerFactory emf = jakarta.persistence.Persistence.createEntityManagerFactory("firstJava");

    public static void main(String[] args) {

    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }


}
