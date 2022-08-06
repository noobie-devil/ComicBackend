package web.backend.comic.Model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = Role.TABLE_NAME)
public class Role {

    public static final String TABLE_NAME = "Role";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long roleId;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Column(name = "name")
    private String name;
}
