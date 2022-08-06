package web.backend.comic.Repository;

import web.backend.comic.Model.ComicSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ComicSeriesRepository extends JpaRepository<ComicSeries, UUID> {
}
