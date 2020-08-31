package pl.akademiakodu.kwejk;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Gif {

    private String name;

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
        GIFS.add(new Gif("android-explosion"));
        GIFS.add(new Gif("ben-and-mike"));
        GIFS.add(new Gif("book-dominos"));
        GIFS.add(new Gif("compiler-bot"));
        GIFS.add(new Gif("cowboy-coder"));
        GIFS.add(new Gif("infinite-andrew"));
    }

}
