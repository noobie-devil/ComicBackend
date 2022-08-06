package web.backend.comic.Model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = ChapterComic.TABLE_NAME)
public class ChapterComic {
    public static final String TABLE_NAME = "ChapterComic";

    @Id
    @GeneratedValue
    @Column(name = "chapter_id")
    private UUID chapterId;

    @ManyToOne
    @JoinColumn(name = "comic_id")
    private ComicSeries comics;

    @NotBlank(message = "Chapter name is required")
    @Column(name = "chapter_name")
    private String chapterName;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "view_count", columnDefinition = "integer default 0")
    private int viewCount;

    @Column(name = "url_thumbnail")
    private String urlThumbnail;

    @Column(name = "seo_alias")
    private String seoAlias;

    @OneToMany(mappedBy = "chapterComic")
    private Set<UrlImageComic> urlImages;

}
