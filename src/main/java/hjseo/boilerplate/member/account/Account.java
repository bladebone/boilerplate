package hjseo.boilerplate.member.account;

import hjseo.boilerplate.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "account")
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Builder
    public Account(
            Long id,
            String name,
            String email,
            Long createdBy,
            LocalDateTime createdAt,
            Long updatedBy,
            LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.setCreatedBy(createdBy);
        this.setCreatedAt(createdAt);
        this.setUpdatedBy(updatedBy);
        this.setUpdatedAt(updatedAt);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                super.toString() +
                '}';
    }
}
