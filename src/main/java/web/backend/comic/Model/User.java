package web.backend.comic.Model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = User.TABLE_NAME)
public class User {

    public static final String TABLE_NAME = "User";

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    private String email;

    @Column(name = "phone_number")
    @Nullable
    private String phoneNumber;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "dob")
    private Date dob;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<Role> roles;

}
