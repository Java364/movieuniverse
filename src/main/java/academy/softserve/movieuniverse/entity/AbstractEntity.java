package academy.softserve.movieuniverse.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private LocalDateTime  entryCreationDate;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime  entryLastUpdate;

    @Column(name = "is_removed", columnDefinition = "BIT DEFAULT 0")
    private Boolean isRemoved;

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

	public LocalDateTime getEntryCreationDate() {
		return entryCreationDate;
	}

	public void setEntryCreationDate(LocalDateTime entryCreationDate) {
		this.entryCreationDate = entryCreationDate;
	}

	public LocalDateTime getEntryLastUpdate() {
		return entryLastUpdate;
	}

	public void setEntryLastUpdate(LocalDateTime entryLastUpdate) {
		this.entryLastUpdate = entryLastUpdate;
	}
}
