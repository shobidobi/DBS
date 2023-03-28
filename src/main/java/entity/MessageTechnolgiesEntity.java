package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "MessageTechnolgies", schema = "public", catalog = "SendMessage")
public class MessageTechnolgiesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;

    public MessageTechnolgiesEntity(String descriptionTechnology) {
        this.descriptionTechnology = descriptionTechnology;
    }

    @Basic
    @Column(name = "DescriptionTechnology")
    private String descriptionTechnology;

    public MessageTechnolgiesEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionTechnology() {
        return descriptionTechnology;
    }

    public void setDescriptionTechnology(String descriptionTechnology) {
        this.descriptionTechnology = descriptionTechnology;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageTechnolgiesEntity that = (MessageTechnolgiesEntity) o;

        if (id != that.id) return false;
        if (descriptionTechnology != null ? !descriptionTechnology.equals(that.descriptionTechnology) : that.descriptionTechnology != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (descriptionTechnology != null ? descriptionTechnology.hashCode() : 0);
        return result;
    }
}
