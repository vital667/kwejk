package pl.akademiakodu.kwejk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.kwejk.entity.Gif;
import pl.akademiakodu.kwejk.repo.GifRepository;

import java.util.ArrayList;
import java.util.Arrays;
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


    // @RequestMapping(value = "/getHome", method = RequestMethod.GET)
    //@RequestMapping(value = "/gifs/search", method = RequestMethod.POST)
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
        // System.out.println(gifs);

        //Iterable<Gif> iterable;
//        List<Gif>list=new ArrayList<>();
//        iterable.forEach(list::add);

//        System.out.println(    )

//        for (Gif gif : gifRepository.findAll())
//            if (gif.getName().equals(name)) {
//                map.put("gif", gif);
//                return "gif-details";
//            } else {
//                return "home";
//            }

//        map.put("gif", ((List<Gif>) gifRepository.findAll()).stream().
//                filter(g -> g.getName().equals(name)).findFirst().get());
        // return "redirect:/";
        //return "home";
        // return "home";

    }


    @GetMapping("/favorites")
    public String getFavorites(ModelMap map) {
        map.put("gifs", gifRepository.findAll());
        return "favorites";
    }
}
