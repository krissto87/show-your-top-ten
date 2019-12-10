package krissto87.showyourtopten.domain.repositories;

import krissto87.showyourtopten.domain.entities.ListPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListPositionRepository extends JpaRepository<ListPosition, Long> {
}
