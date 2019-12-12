package krissto87.showyourtopten.domain.repositories;

import krissto87.showyourtopten.domain.entities.ListPosition;
import krissto87.showyourtopten.domain.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListPositionRepository extends JpaRepository<ListPosition, Long> {
}
