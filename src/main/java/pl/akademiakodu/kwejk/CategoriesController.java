package pl.akademiakodu.kwejk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoriesController {

    @GetMapping("/categories")
    public String getCategories(ModelMap map) {
        map.put("categories", Category.CATEGORIES);
        return "categories";
    }

    @GetMapping("/category/{number}")
    public String getCategories(@PathVariable int number, ModelMap map) {
        for (Category category : Category.CATEGORIES)
            if (category.getId() == number)
                map.put("category", category);

        List<Gif> list = new ArrayList<>();
        for (Gif gif : Gif.GIFS)
            if (gif.getCategory() == number)
                list.add(gif);
        map.put("gifs", list);

        return "category";
    }

}
