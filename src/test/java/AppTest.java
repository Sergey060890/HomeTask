
import entity.HomeTask;
import entity.Person;
import entity.Task;
import org.hibernate.HibernateException;
import org.junit.*;
import service.HibernateUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class AppTest {
    @Test
    public void saveTestWheel() throws Exception{
        Task homeTaskTest = HomeTask.builder()
                .startDate(LocalDate.of(2022,4,14))
                .endDate(LocalDate.of(2022,4,18))
                .executorPerson(new Person("Dolce", "Gabbana"))
                .observerPerson(new Person("Tommy", "Hilfiger"))
                .name("TaskTest")
                .description("HomeWorkTest")
                .build();
        EntityManager entityManager = HibernateUtil.getEntityManager();//Java Persistence API
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(homeTaskTest);
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().begin();
        Task homeTaskTest1 = entityManager.find(Task.class, homeTaskTest.getId());
        Assert.assertEquals(homeTaskTest,homeTaskTest1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @AfterClass
    public static void clean()throws Exception{
        HibernateUtil.close();
    }
}
