package Logic;

import entity.MessageEntity;
import entity.MessageTechnolgiesEntity;
import jakarta.persistence.*;

import java.util.List;

public class Tecnologic {
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction transaction=entityManager.getTransaction();
    public boolean isTecintable(String Tec,int id){
        //query of tec
        if (id==-1){
            Query q=entityManager.createQuery("SELECT e from MessageTechnolgiesEntity e where e.descriptionTechnology=:id");
            q.setParameter("id", Tec);
            List<MessageTechnolgiesEntity> z=q.getResultList();
            if (z.size()==0){return false;}
            return true;
        }
        //query of id
        else {
            Query q=entityManager.createQuery("SELECT e from MessageTechnolgiesEntity e where e.id=:id");
            q.setParameter("id", id);
            List<MessageTechnolgiesEntity> z=q.getResultList();
            if (z.size()==0){return false;}
            return true;
        }
    }
    public void addTec(String Tec){
        if(!isTecintable(Tec,-1)) {
            transaction.begin();
            MessageTechnolgiesEntity add=new MessageTechnolgiesEntity(Tec);
            entityManager.persist(add);
            transaction.commit();
        }
    }//הוספת טכנולוגיה
    public void removeTec(int idD){
        Query q=entityManager.createQuery("DELETE from MessageTechnolgiesEntity e where e.id=:idD");
        q.setParameter("idD", idD);
        if (isTecintable("",idD)){
            transaction.begin();
            q.executeUpdate();
            transaction.commit();
        }
    }//מחיקת טכנולוגיה
}
