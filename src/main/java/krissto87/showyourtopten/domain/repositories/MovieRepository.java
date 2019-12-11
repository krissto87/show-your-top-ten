package krissto87.showyourtopten.domain.repositories;

import krissto87.showyourtopten.domain.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
