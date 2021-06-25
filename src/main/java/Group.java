import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "climbing_tb")
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(optional = false)
    @JoinColumn(name="mountain", unique = true, nullable = false, updatable = true)
    private Mountain mountain;

    @Column(nullable = false)
    private LocalDateTime start;

    @OrderColumn(name = "climbers", nullable = false)
    @OneToMany(fetch = FetchType.LAZY)
    private Climber[] climbers;

}
