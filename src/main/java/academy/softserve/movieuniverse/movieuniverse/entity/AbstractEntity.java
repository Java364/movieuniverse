package academy.softserve.movieuniverse.movieuniverse.entity;

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
}
