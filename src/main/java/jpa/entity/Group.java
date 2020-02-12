package jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ifmo_group")
@NoArgsConstructor
@RequiredArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Group.getAll", query = "SELECT g FROM Group g"),
        @NamedQuery(name = "Group.findByNAme",
                query = "SELECT g FROM Group g WHERE g.groupName = :groupName")
})
public class Group extends BaseIdentify{
    @Getter
    @Setter
    @NonNull
    private String groupName;

    @Getter
    @Setter
    @NonNull
    private int duration;

    @Getter
    @Setter
    @NonNull
    private int price;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    private List<Student> students = new ArrayList<>();
}
