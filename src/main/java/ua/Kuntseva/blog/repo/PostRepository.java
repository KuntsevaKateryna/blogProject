package ua.Kuntseva.blog.repo;

import org.springframework.data.repository.CrudRepository;
import ua.Kuntseva.blog.models.Post;

//для манипулирования записями Post, Long - тип ID в Post
public interface PostRepository extends CrudRepository<Post, Long> {
}
