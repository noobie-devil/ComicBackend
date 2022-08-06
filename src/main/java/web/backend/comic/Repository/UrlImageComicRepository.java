package web.backend.comic.Repository;

import web.backend.comic.Model.UrlImageComic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UrlImageComicRepository extends JpaRepository<UrlImageComic, UUID> {
}
