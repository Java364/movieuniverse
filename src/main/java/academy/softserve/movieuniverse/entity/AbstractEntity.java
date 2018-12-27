package academy.softserve.movieuniverse.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
//    private Date entryCreationDate;
//
//    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private Date entryLastUpdate;


    @Column(name = "created_at", updatable = false)
    private Date entryCreationDate = new Date();

    @Column(name = "updated_at")
    private Date entryLastUpdate = new Date();


    @Column(name = "is_removed")
    private Boolean isRemoved = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(Boolean isRemoved) {
        this.isRemoved = isRemoved;
    }

    public Date getEntryCreationDate() {
        return entryCreationDate;
    }

    public void setEntryCreationDate(Date entryCreationDate) {
        this.entryCreationDate = entryCreationDate;
    }

    public Date getEntryLastUpdate() {
        return entryLastUpdate;
    }

    public void setEntryLastUpdate(Date entryLastUpdate) {
        this.entryLastUpdate = entryLastUpdate;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                ", entryCreationDate=" + entryCreationDate +
                ", entryLastUpdate=" + entryLastUpdate +
                ", isRemoved=" + isRemoved +
                '}';
    }
}
