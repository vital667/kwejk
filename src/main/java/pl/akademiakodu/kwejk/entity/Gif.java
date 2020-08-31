package pl.akademiakodu.kwejk.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "GIF")
@Entity
@Data
@NoArgsConstructor
public class Gif {

    @Column(name="ID")
    @Id
    private int id;

    @Column(name="GNAME")
    private String name;
    @Column(name="FAVORITE")
    private boolean favorite;
    @Column(name="CATEGORY")
    private int category;

    public String getFilePath(){
        return "/gifs/"+name+".gif";
    }

//    public static List<Gif> GIFS = new ArrayList<>();

    //służy do inicjalizacji zmiennych statycznych
    //wykonywany na samym początku uruchomienia pliku
    //blok statyczny
    //hard kodowanie danych
    //symulacja bazy danych
//    static{
//        GIFS.add(new Gif("android-explosion",true,1));
//        GIFS.add(new Gif("ben-and-mike",false,1));
//        GIFS.add(new Gif("book-dominos",true,2));
//        GIFS.add(new Gif("compiler-bot",false,2));
//        GIFS.add(new Gif("cowboy-coder",true,3));
//        GIFS.add(new Gif("infinite-andrew",true,3));
//    }

}
