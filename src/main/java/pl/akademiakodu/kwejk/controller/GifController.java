package pl.akademiakodu.kwejk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.kwejk.entity.Gif;
import pl.akademiakodu.kwejk.repo.GifRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/")
    public String getHome(ModelMap map) {
        map.put("gifs", gifRepository.findAll());
        return "home";
    }


    @GetMapping("/gif/{name}")
    public String getGif(@PathVariable String name,
                         ModelMap map) {
        map.put("gif", ((List<Gif>) gifRepository.findAll()).stream().
                filter(g -> g.getName().equals(name)).findFirst().get());
        return "gif-details";
    }


    @GetMapping("/gifs/search")
    @PostMapping(value = "/gifs/search")
    public String searchGifs(@RequestParam String name,
                             ModelMap map) {
        List<Gif> gifs = new ArrayList<>();

        for (Gif gif : gifRepository.findAll())
            if (gif.getName().contains(name)) {
                gifs.add(gif);
            }
        if (!gifs.isEmpty()) {
            map.put("gifs", gifs);
            return "home";
        } else return "redirect:/";
    }


    @GetMapping("/favorites")
    public String getFavorites(ModelMap map) {
        map.put("gifs", gifRepository.findAll());
        return "favorites";
    }
}
