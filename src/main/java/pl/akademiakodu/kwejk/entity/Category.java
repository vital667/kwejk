package pl.akademiakodu.kwejk.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "CATEGORY")
@Entity
@NoArgsConstructor
@Data
public class Category {

    @Column(name="ID")
    @Id
    private int id;
    @Column(name="CNAME")
    private String name;
}
