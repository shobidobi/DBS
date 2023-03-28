package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Technology_preference", schema = "public", catalog = "SendMessage")
public class TechnologyPreferenceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "userid")
    private Integer userid;

    public TechnologyPreferenceEntity(Integer userid, Integer messageTechnolgies) {
        this.userid = userid;
        this.messageTechnolgies = messageTechnolgies;
    }

    @Basic
    @Column(name = "MessageTechnolgies")
    private Integer messageTechnolgies;

    public TechnologyPreferenceEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

        TechnologyPreferenceEntity that = (TechnologyPreferenceEntity) o;

        if (id != that.id) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (messageTechnolgies != null ? !messageTechnolgies.equals(that.messageTechnolgies) : that.messageTechnolgies != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (messageTechnolgies != null ? messageTechnolgies.hashCode() : 0);
        return result;
    }
}
