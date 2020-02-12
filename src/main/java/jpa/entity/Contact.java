package jpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student_contact")
@NoArgsConstructor
@RequiredArgsConstructor
public class Contact extends BaseIdentify {
    @Getter
    @Setter
    @NonNull
    private String name;
    @Getter
    @Setter
    @NonNull
    private int age;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
}