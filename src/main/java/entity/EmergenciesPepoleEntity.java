package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emergencies_pepole", schema = "public", catalog = "SendMessage")
public class EmergenciesPepoleEntity {
    public EmergenciesPepoleEntity(Integer userId, Integer emergencyId) {
        this.userId = userId;
        this.emergencyId = emergencyId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "emergency_id")
    private Integer emergencyId;

    public EmergenciesPepoleEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEmergencyId() {
        return emergencyId;
    }

    public void setEmergencyId(Integer emergencyId) {
        this.emergencyId = emergencyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmergenciesPepoleEntity that = (EmergenciesPepoleEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (emergencyId != null ? !emergencyId.equals(that.emergencyId) : that.emergencyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (emergencyId != null ? emergencyId.hashCode() : 0);
        return result;
    }
}
