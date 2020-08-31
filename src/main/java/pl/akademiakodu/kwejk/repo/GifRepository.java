package pl.akademiakodu.kwejk.repo;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.kwejk.entity.Gif;

public interface GifRepository extends CrudRepository<Gif, Integer> {
}
