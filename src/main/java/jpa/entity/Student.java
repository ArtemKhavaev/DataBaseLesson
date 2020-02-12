package jpa.entity;

import lombok.*;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Cache(
        type = CacheType.SOFT,
        expiry = 360000, //6 min
        size = 64000
)
public class Student extends BaseIdentify {

    @Getter
    @Setter
    @NonNull
    private String email;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
    private Contact contact;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "student_group",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groups = new ArrayList<>();
}