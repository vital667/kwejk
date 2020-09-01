package pl.akademiakodu.kwejk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.akademiakodu.kwejk.entity.Category;
import pl.akademiakodu.kwejk.entity.Gif;
import pl.akademiakodu.kwejk.repo.CategoryRepository;
import pl.akademiakodu.kwejk.repo.GifRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CategoriesController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/categories")
    public String getCategories(ModelMap map) {
        map.put("categories", categoryRepository.findAll());
        return "categories";
    }


    @GetMapping("/category/{number}")
    public String getCategories(@PathVariable int number, ModelMap map) {
            map.put("category",((List<Category>)categoryRepository.findAll())
                    .stream().
                    filter(category -> category.getId()==number).findFirst().get());

            map.put("gifs",((List<Gif>)gifRepository.findAll())
            .stream()
            .filter(gif -> gif.getCategory()==number).collect(Collectors.toList()));
        return "category";
    }
}
