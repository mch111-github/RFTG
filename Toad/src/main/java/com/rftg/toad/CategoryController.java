package com.rftg.toad;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;






@Controller // This means that this class is a Controller
@RequestMapping(path="/categories") // This means URL's start with /demo (after Application path)
public class CategoryController {
    @Autowired 
    private CategoryRepository categoryRepository;
    @Autowired
    private FilmRepository filmRepository;
  // private CategoryRepository CategoryRepository;

  @GetMapping(path="/categories/films")
  public @ResponseBody Iterable<Film> getAll(){
    // This returns a JSON or XML with the Films d'une category
    return filmRepository.findAll();

  }

  @GetMapping()  //TW ALEXIS
  public @ResponseBody Iterable<Category> getAllCategorys() {
    // This returns a JSON or XML with the Films
    return categoryRepository.findAll();
  }



}
