package pl.akademiakodu.kwejk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.akademiakodu.kwejk.entity.Gif;
import pl.akademiakodu.kwejk.repo.GifRepository;

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
    //____________
//        for (Gif gif : Gif.GIFS)
//            if (gif.getName().equals(name))
//                map.put("gif", gif);
//
//            Gif gif= Gif.GIFS.stream().
//                    filter(g->g.getName().equals(name)).findFirst().get();
//
//            map.put("gif",gif);
//_______________
//        List<Gif> gifs= (List<Gif>) gifRepository.findAll();

        map.put("gif", ((List<Gif>) gifRepository.findAll()).stream().
                filter(g -> g.getName().equals(name)).findFirst().get());
        return "gif-details";
    }


    @GetMapping("/favorites")
    public String getFavorites(ModelMap map) {
        map.put("gifs", gifRepository.findAll());
        return "favorites";
    }
}
