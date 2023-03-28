package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "message", schema = "public", catalog = "SendMessage")
public class MessageEntity {
    public MessageEntity(String textOfMes) {
        this.textOfMes = textOfMes;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "text_of_mes")
    private String textOfMes;

    public MessageEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextOfMes() {
        return textOfMes;
    }

    public void setTextOfMes(String textOfMes) {
        this.textOfMes = textOfMes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (id != that.id) return false;
        if (textOfMes != null ? !textOfMes.equals(that.textOfMes) : that.textOfMes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (textOfMes != null ? textOfMes.hashCode() : 0);
        return result;
    }
}
