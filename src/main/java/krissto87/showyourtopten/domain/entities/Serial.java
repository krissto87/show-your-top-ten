package krissto87.showyourtopten.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "serials")
@Getter @Setter
@ToString @EqualsAndHashCode(of = "id")
public class Serial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String type;
    private String creator;
    private String description;
}
