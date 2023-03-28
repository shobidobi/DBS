package Logic;

import entity.MessageEntity;
import entity.MessageTechnolgiesEntity;
import jakarta.persistence.*;

import java.util.List;

public class Message {
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    EntityTransaction transaction=entityManager.getTransaction();
    public boolean isMessintable(String message,int id){
        //query of Message
        if (id==-1){
            Query q=entityManager.createQuery("SELECT e from MessageEntity e where e.textOfMes=:id");
            q.setParameter("id", message);
            List<MessageEntity> z=q.getResultList();
            if (z.size()==0){return false;}
            return true;
        }
        //query of id
        else {
            Query q=entityManager.createQuery("SELECT e from MessageEntity e where e.id=:id");
            q.setParameter("id", id);
            List<MessageEntity> z=q.getResultList();
            if (z.size()==0){return false;}
            return true;
        }
    }
    public void addMessage(String message){
        if (!isMessintable(message,-1)){
            transaction.begin();
            MessageEntity newm=new MessageEntity(message);
            entityManager.persist(newm);
            transaction.commit();
        }
    }//הוספת הודעה
    public void removeMessage(int idD){

        Query q=entityManager.createQuery("DELETE from MessageEntity e where e.id=:idD");
        q.setParameter("idD", idD);
        if(isMessintable("",idD)){
            transaction.begin();
            q.executeUpdate();
            transaction.commit();
        }

    }//מחיקת הודעה

}
