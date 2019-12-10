package krissto87.showyourtopten.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "list_position")
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
