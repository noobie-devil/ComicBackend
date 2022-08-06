package web.backend.comic.Model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = ComicSeries.TABLE_NAME)
public class ComicSeries {
    public static final String TABLE_NAME = "ComicSeries";

    @Id
    @GeneratedValue
    @Column(name = "comic_id")
    private UUID comicId;

    @NotBlank(message = "Comic name is required")
    @Column(name = "comic_name")
    private String comicName;

    @Nullable
    @Column(name = "comic_different_name")
    private String comicDifferentName;

    @Column(name = "view_count", columnDefinition = "integer default 0")
    private int viewCount;

    @Column(name = "url_cover_image")
    private String urlCoverImage;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;

    @Column(name = "seo_alias")
    private String seoAlias;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "seo_description")
    private String seoDescription;

    @Column(name = "seo_title")
    private String seoTitle;

    @Column(columnDefinition = "tinyint default 0")
    private int status;

    @Column(columnDefinition = "double default 0")
    private double rating;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comics", cascade = CascadeType.ALL)
    private Set<ChapterComic> chapterComics = new HashSet<>();

    @ManyToMany
    @JoinTable(name="categories_comics", joinColumns = @JoinColumn(name = "comic_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
