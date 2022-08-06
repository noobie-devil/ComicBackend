package web.backend.comic.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = Category.TABLE_NAME)
public class Category {
    public static final String TABLE_NAME = "Category";

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long categoryId;

    @NotBlank(message = "Category name is required")
    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "seo_alias")
    private String seoAlias;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @Column(name = "url_icon_category")
    private String urlIconCategory;

    @Column(name = "icon_text")
    private String iconText;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Category> subCategory = new HashSet<>();

    @ManyToMany(mappedBy = "categories")
    private Set<ComicSeries> comics = new HashSet<>();
}
