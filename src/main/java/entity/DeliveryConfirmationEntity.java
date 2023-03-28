package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "delivery_confirmation", schema = "public", catalog = "SendMessage")
@IdClass(DeliveryConfirmationEntityPK.class)
public class DeliveryConfirmationEntity {
    public DeliveryConfirmationEntity(int userId, int messageId, Date date, Integer messageTechnolgies) {
        this.userId = userId;
        this.messageId = messageId;
        this.date = date;
        this.messageTechnolgies = messageTechnolgies;
    }

    @Basic
    @Column(name = "id")
    private int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "message_id")
    private int messageId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "Message_technolgies")
    private Integer messageTechnolgies;

    public DeliveryConfirmationEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMessageTechnolgies() {
        return messageTechnolgies;
    }

    public void setMessageTechnolgies(Integer messageTechnolgies) {
        this.messageTechnolgies = messageTechnolgies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryConfirmationEntity that = (DeliveryConfirmationEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (messageId != that.messageId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (messageTechnolgies != null ? !messageTechnolgies.equals(that.messageTechnolgies) : that.messageTechnolgies != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + messageId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (messageTechnolgies != null ? messageTechnolgies.hashCode() : 0);
        return result;
    }
}
