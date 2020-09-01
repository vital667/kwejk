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
}
