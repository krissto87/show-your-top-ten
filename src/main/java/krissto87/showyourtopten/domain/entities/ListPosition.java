package krissto87.showyourtopten.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "list_position")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ListPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OrderColumn(nullable = false)
    private Integer position;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Serial serial;
}
