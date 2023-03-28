package Logic;

import jakarta.persistence.*;

import java.util.List;

public class preuser {
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction transaction=entityManager.getTransaction();
    public List sel(int IDUser){
        Query q=entityManager.createQuery("SELECT TechnologyPreferenceEntity .userid,MessageTechnolgiesEntity.descriptionTechnology,TechnologyPreferenceEntity.messageTechnolgies\n" +
                "FROM TechnologyPreferenceEntity \n" +
                "INNER JOIN MessageTechnolgiesEntity ON TechnologyPreferenceEntity.messageTechnolgies=MessageTechnolgiesEntity.id");
        List l=q.getResultList();
        return l;
    }
    public List sel2(int idTec){
        Query q=entityManager.createQuery("SELECT TechnologyPreferenceEntity .userid,MessageTechnolgiesEntity.descriptionTechnology,TechnologyPreferenceEntity.messageTechnolgies\n" +
                "FROM MessageTechnolgiesEntity \n" +
                "INNER JOIN TechnologyPreferenceEntity ON TechnologyPreferenceEntity.messageTechnolgies=MessageTechnolgiesEntity.id");
        List l=q.getResultList();
        return l;
    }
}
