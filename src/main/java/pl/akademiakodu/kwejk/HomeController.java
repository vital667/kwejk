package pl.akademiakodu.kwejk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(ModelMap map) {
        map.put("gifs", Gif.GIFS);
        return "home";
    }

    @GetMapping("/gif/{name}")
    public String getGif(@PathVariable String name,
                         ModelMap map) {
//        for (Gif gif : Gif.GIFS)
//            if (gif.getName().equals(name))
//                map.put("gif", gif);
//
//            Gif gif= Gif.GIFS.stream().
//                    filter(g->g.getName().equals(name)).findFirst().get();
//
//            map.put("gif",gif);

        map.put("gif", Gif.GIFS.stream().
                filter(g -> g.getName().equals(name)).findFirst().get());
        return "gif-details";
    }


    @GetMapping("/favorites")
    public String getFavorites(ModelMap map){
        map.put("gifs", Gif.GIFS);
        return "favorites";
    }
}
