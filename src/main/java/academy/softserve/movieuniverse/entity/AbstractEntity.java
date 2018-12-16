package academy.softserve.movieuniverse.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Long entryCreationDate;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Long entryLastUpdate;

    @Column(name = "is_removed", columnDefinition = "BIT DEFAULT 0")
    private Boolean isRemoved;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntryCreationDate() {
        return entryCreationDate;
    }

    public void setEntryCreationDate(Long entryCreationDate) {
        this.entryCreationDate = entryCreationDate;
    }

    public Long getEntryLastUpdate() {
        return entryLastUpdate;
    }

    public void setEntryLastUpdate(Long entryLastUpdate) {
        this.entryLastUpdate = entryLastUpdate;
    }

    public Boolean getIsRemoved() {
        return isRemoved;
    }

    public void setIsRemoved(Boolean isRemoved) {
        this.isRemoved = isRemoved;
    }
}
