package pl.akademiakodu.kwejk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

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

//    public static List<Category> CATEGORIES = new ArrayList<>();
//
//    static {
//        CATEGORIES.add(new Category(1,"Osoby"));
//        CATEGORIES.add(new Category(2,"Sport"));
//        CATEGORIES.add(new Category(3,"Memy"));
//    }
}
