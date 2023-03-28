package Logic;

import entity.EmergenciesPepoleEntity;
import entity.TechnologyPreferenceEntity;
import jakarta.persistence.*;

import java.util.List;

public class technologyPreference {
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction transaction=entityManager.getTransaction();
    public boolean isTP(int userId, int messageTechnolgies){
        Query q=entityManager.createQuery("SELECT e from TechnologyPreferenceEntity e where e.userid=:uid and e.messageTechnolgies=:eid");
        q.setParameter("uid", userId);
        q.setParameter("eid", messageTechnolgies);
        List<TechnologyPreferenceEntity> z=q.getResultList();
        if (z.size()==0){return false;}
        return true;
    }
    public void addEmergencyPepole(int userId, int messageTechnolgies){
        if (!(isTP(userId, messageTechnolgies))){
            transaction.begin();
            TechnologyPreferenceEntity technologyPreference=new TechnologyPreferenceEntity(userId,messageTechnolgies);
            entityManager.persist(technologyPreference);
            transaction.commit();
        }
    }
    public void removeEmergencyPepole(int userId, int messageTechnolgies){
        Query q=entityManager.createQuery("DELETE from TechnologyPreferenceEntity e where e.userid=:uid and e.messageTechnolgies=:eid");
        q.setParameter("uid", userId);
        q.setParameter("eid", messageTechnolgies);
        if(isTP(userId, messageTechnolgies)){
            transaction.begin();
            q.executeUpdate();
            transaction.commit();
        }
    }
}
