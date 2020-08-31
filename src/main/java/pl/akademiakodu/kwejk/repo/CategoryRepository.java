package pl.akademiakodu.kwejk.repo;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.kwejk.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
