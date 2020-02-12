
package jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseIdentify {
//    @TableGenerator(name = "tgenerator", initialValue = 1)
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tgenerator")

//    @SequenceGenerator(name = "sgenerator", initialValue = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sgenerator")

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
}