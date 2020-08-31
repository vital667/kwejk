package pl.akademiakodu.kwejk;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Gif {

    private String name;
    private boolean favorite;
    private int category;

    public String getFilePath(){
        return "/gifs/"+name+".gif";
    }

    public static List<Gif> GIFS = new ArrayList<>();

    //służy do inicjalizacji zmiennych statycznych
    //wykonywany na samym początku uruchomienia pliku
    //blok statyczny
    //hard kodowanie danych
    //symulacja bazy danych
    static{
        GIFS.add(new Gif("android-explosion",true,1));
        GIFS.add(new Gif("ben-and-mike",false,1));
        GIFS.add(new Gif("book-dominos",true,2));
        GIFS.add(new Gif("compiler-bot",false,2));
        GIFS.add(new Gif("cowboy-coder",true,3));
        GIFS.add(new Gif("infinite-andrew",true,3));
    }

}
