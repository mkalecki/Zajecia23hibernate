package pl.javastart.hibernateintro;

import pl.javastart.hibernateintro.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("podaj imię uzytkownika");
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("db");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        User user = new User();
        user.setName(userName);
        user.setCreationDate(new Date());

//        User wojtek = new User();
//        wojtek.setName("Wojtek");

        entityManager.persist(user);
//        entityManager.persist(wojtek);

        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();

    }
}
