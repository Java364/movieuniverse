package academy.softserve.movieuniverse.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private LocalDateTime entryCreationDate;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime entryLastUpdate;

    @Column(name = "is_removed")
    private Boolean isRemoved;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getIsRemoved() {
		return isRemoved;
	}

	public void setIsRemoved(Boolean isRemoved) {
		this.isRemoved = isRemoved;
	}
}
