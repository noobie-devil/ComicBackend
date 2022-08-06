package web.backend.comic.Model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = UrlImageComic.TABLE_NAME)
public class UrlImageComic {

    public static final String TABLE_NAME = "UrlImageComic";

    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private UUID imageId;

    @ManyToOne
    @MapsId("chapterId")
    @JoinColumn(name = "chapter_id")
    private ChapterComic chapterComic;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "url")
    private String url;

}
