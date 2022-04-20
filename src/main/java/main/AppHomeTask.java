package main;

import entity.HomeTask;
import entity.Person;
import entity.Task;
import entity.WorkTask;
import service.HibernateUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class AppHomeTask {
    public static final int COST_FOR_WORK_TASK = 500;

    public static void main(final String[] args) {
        Task homeTask = HomeTask.builder()
                .startDate(LocalDate.of(2022,4,14))
                .endDate(LocalDate.of(2022,4,18))
                .executorPerson(new Person("Paco", "Rabbane"))
                .observerPerson(new Person("Viktoria", "Secret"))
                .name("Task1")
                .description("Homework")
                .build();
        Task workTask = WorkTask.builder()
                .name("Task2")
                .description("WorkTask")
                .cost(COST_FOR_WORK_TASK)
                .build();

        Task task1 = Task.builder()
                .name("Task1")
                .description("Homework")
                .build();
        Task task2 = Task.builder()
                .name("Task2")
                .description("WorkTask")
                .build();


        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(homeTask);
        em.persist(workTask);
        em.persist(task1);
        em.persist(task2);
        em.getTransaction().commit();
        em.close();
    }
}
