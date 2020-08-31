package pl.akademiakodu.kwejk;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Category {

    private int id;
    private String name;

    public static List<Category> CATEGORIES = new ArrayList<>();

    static {
        CATEGORIES.add(new Category(1,"Osoby"));
        CATEGORIES.add(new Category(2,"Sport"));
        CATEGORIES.add(new Category(3,"Memy"));
    }
}
