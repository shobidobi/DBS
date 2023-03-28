package Logic;

import entity.MessageEntity;
import jakarta.persistence.*;
import entity.EmergenciesPepoleEntity;

import java.util.List;

public class EmergencyPepole {
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction transaction=entityManager.getTransaction();
    public boolean isEP(int userId, int emergencyId){
        Query q=entityManager.createQuery("SELECT e from EmergenciesPepoleEntity e where e.userId=:uid and e.emergencyId=:eid");
        q.setParameter("uid", userId);
        q.setParameter("eid", emergencyId);
        List<EmergenciesPepoleEntity> z=q.getResultList();
        if (z.size()==0){return false;}
        return true;
    }
    public void addEmergencyPepole(int userId, int emergencyId){
        if (!(isEP(userId, emergencyId))){
            transaction.begin();
            EmergenciesPepoleEntity emergenciesPepole=new EmergenciesPepoleEntity(userId,emergencyId);
            entityManager.persist(emergenciesPepole);
            transaction.commit();
        }
    }
    public void removeEmergencyPepole(int userId, int emergencyId){
        Query q=entityManager.createQuery("DELETE from EmergenciesPepoleEntity e where e.userId=:uid and e.emergencyId=:eid");
        q.setParameter("uid", userId);
        q.setParameter("eid", emergencyId);
        if(isEP(userId, emergencyId)){
            transaction.begin();
            q.executeUpdate();
            transaction.commit();
        }
    }
}
