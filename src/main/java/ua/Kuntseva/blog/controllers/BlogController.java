package ua.Kuntseva.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.Kuntseva.blog.models.Post;
import ua.Kuntseva.blog.repo.PostRepository;
import java.util.Optional;


@Controller
public class BlogController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping("/blog10") // можна написать как угодно. Закладка будет с таким имененем.
    // А переход будет осуществляться именно на страницу в return "blog-main";
    public String blog (Model model) {
        Iterable<Post> iterator = postRepository.findAll();
        model.addAttribute("posts", iterator);
        return "blog-main";
    }

    @GetMapping("/addblog")
        public String addblog (Model model) {
        return "blog-add";
    }

    @PostMapping("/addblog")
    public String postAddblog (@RequestParam String title_,
                               @RequestParam String annons_,
                               @RequestParam String full_text_,
                               Model model) {
        Post post= new Post(title_, annons_,full_text_);
        postRepository.save(post);
        return "redirect:/blog10";
    }

    @GetMapping("/blog/{id}") // id - dynamic param
    public String blogDetails (@PathVariable(value = "id") long id,
                               Model model) {
        if (!postRepository.existsById(id))
            return "redirect:/blog10";
         Optional <Post> post = postRepository.findById(id);
        Post p = post.isPresent() ? post.get() : new Post();
         model.addAttribute("post", p);
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit") // id - dynamic param
    public String blogEdit (@PathVariable(value = "id") long id,
                               Model model) {
        if (!postRepository.existsById(id))
            return "redirect:/blog10";
        Optional <Post> post = postRepository.findById(id);
        Post p = post.isPresent() ? post.get() : new Post();
        model.addAttribute("post", p);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String postUpdateblog (  @PathVariable(value = "id") long id,
                                    @RequestParam String title,
                                    @RequestParam String annons,
                                    @RequestParam String full_text,
                                    Model model) {
        Post post = null;
        try {
            post = postRepository.findById(id).orElseThrow(
                    () -> new Exception("Blog not found - " + title));
            post.setTitle(title);
            post.setAnnons(annons);
            post.setFull_text(full_text);
            postRepository.save(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/blog10";
    }

    @PostMapping("/blog/{id}/delete")
    public String postUpdateblog (  @PathVariable(value = "id") long id,
                                    Model model) {
        Post post = null;
        try {
            post = postRepository.findById(id).orElseThrow(
                    () -> new Exception("Blog not found"));

            postRepository.delete(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/blog10";
    }
}
