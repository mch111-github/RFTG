package com.rftg.toad;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/films") 
public class FilmController {
  @Autowired
  private FilmRepository filmRepository;
  @Autowired
  private CategoryRepository categoryRepository;

  @PostMapping(path = "/add") // Map ONLY POST Requests
  public @ResponseBody String addNewFilm(@RequestParam Integer film_id, @RequestParam String title,
      @RequestParam String description, @RequestParam String release_year, @RequestParam String language_id,
      @RequestParam String original_language_id, @RequestParam String rental_duration, @RequestParam String rental_rate,
      @RequestParam String length, @RequestParam String replacement_cost, @RequestParam String rating,
      @RequestParam String special_features, @RequestParam String last_update) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Film n = new Film();
    n.setFilm_id(film_id);
    n.setTitle(title);
    n.setDescription(description);
    n.setRelease_year(release_year);
    n.setLanguage_id(language_id);
    n.setOriginal_language_id(original_language_id);
    n.setRental_duration(rental_duration);
    n.setRental_rate(rental_rate);
    n.setLength(length);
    n.setReplacement_cost(replacement_cost);
    n.setRating(rating);
    n.setSpecial_features(special_features);
    n.setLast_update(last_update);
    filmRepository.save(n);
    return "Saved";
  }

  @GetMapping()
  public @ResponseBody Iterable<Film> getAllFilms() {
    // This returns a JSON or XML with the Films
    System.out.println("ça marche");
    System.out.println(filmRepository.findAll());
    return filmRepository.findAll();
  }

  @GetMapping(path = "/{film_id}")
  public @ResponseBody Film getFilmById(@PathVariable Integer film_id) {
    return filmRepository.findById(film_id).orElse(null);
  }

  @GetMapping("/title/{title}")
    public @ResponseBody Film getFilmByTitle(@PathVariable String title) {
      return filmRepository.findByTitle(title);
  }

  @GetMapping("/category/{categoryName}")
  public @ResponseBody Iterable<Film> getFilmsByCategory(@PathVariable String categoryName) {
      
      Category category = categoryRepository.findByName(categoryName);
  
      
      return filmRepository.findByCategories(category);
  }

    @GetMapping("/actors/{film_id}")
  public @ResponseBody List<Actor> getActorsInFilm(@PathVariable Integer film_id) {
    Film film = filmRepository.findById(film_id).orElse(null);

    if (film != null) {
      return film.getActors();
    } else {
      return Collections.emptyList();
    }

  }

}

