package com.rftg.toad;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Controller // This means that this class is a Controller
@RequestMapping(path="/inventory") // This means URL's start with /demo (after Application path)
public class InventoryController extends InventorySpecifications {
  @Autowired // This means to get the bean called FilmRepository
  private InventoryRepository inventoryRepository;
  @Autowired // This means to get the bean called StateRepository
  private StateRepository stateRepository;
  @PersistenceContext
  private EntityManager entityManager;

  @GetMapping()
  public @ResponseBody Iterable<Inventory> getAllInventory() {
    // This returns a JSON or XML with the Films
    return inventoryRepository.findAll();
  }

    @GetMapping(path = "/{inventory_id}")
  public @ResponseBody Inventory getInventoryById(@PathVariable Integer inventory_id) {
    return inventoryRepository.findById(inventory_id).orElse(null);
  }

      @GetMapping("/store")
    public @ResponseBody List<Inventory> whenSearchingByStoreId(@RequestParam Integer store_id) {
        Specification<Inventory> specifications = HasStoreIdLike(store_id);
        List<Inventory> inventories = inventoryRepository.findAll(specifications);
        return inventories;
    }

    @GetMapping("/film")
    public @ResponseBody Inventory whenSearchingByFilmId(@RequestParam Integer film_id) {
        Specification<Inventory> specifications = HasFilmIdAndState(film_id, 2);
        List<Inventory> inventories = inventoryRepository.findAll(specifications);
        if (!inventories.isEmpty()) {
            Inventory inventory = inventories.get(0);
            return inventory;
        } else {
            return null;
        }
    }

    @PostMapping(path="/addInventory")
    public @ResponseBody Inventory addNewInventory(@RequestParam Integer film_id,
                                                @RequestParam Integer store_id) {

        Inventory newInventory = new Inventory();
        newInventory.setFilm_id(film_id);
        newInventory.setStore_id(store_id);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        newInventory.setLast_update(timestamp);

        newInventory = inventoryRepository.save(newInventory);

        return newInventory;
    }

    @DeleteMapping(path = "/deleteInventory/{inventory_id}")
    public @ResponseBody String updateState(@PathVariable String inventory_id) {
        // Vérifiez d'abord si l'inventaire avec cet ID existe
        int id = Integer.parseInt(inventory_id);
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);

        if (optionalInventory.isPresent()) {
            // Si l'inventaire existe, supprimez-le
            Inventory inventory = optionalInventory.get();
            Optional<State> optionalState = stateRepository.findById(inventory.getState_id());
            State state = optionalState.get();
            int nouvelleValeurStateId = 0;
            if (state.getValeurs() == 0) {
                Optional<State> optionalStateEnStock = stateRepository.findByValeurs(1);
                State stateEnStock = optionalStateEnStock.get();
                nouvelleValeurStateId = stateEnStock.getId();
            } else if (state.getValeurs() == 1) {
                Optional<State> optionalStateHorsStock = stateRepository.findByValeurs(0);
                State stateHorsStock = optionalStateHorsStock.get();
                nouvelleValeurStateId = stateHorsStock.getId();
            }

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            // Contrainte de rental vers inventory et de payment vers rental donc
            // suppression non possible pour l'instant
            inventory.setState_id(nouvelleValeurStateId); // Remplacez "nouvelleValeurStateId" par la nouvelle valeur souhaitée
            inventory.setLast_update(timestamp);
            inventoryRepository.save(inventory);
            return "Update successful";
        } else {
            // Si l'inventaire n'existe pas, renvoyez un message approprié
            return "Inventory not found";
        }
    }

    @PutMapping(path = "/updateInventory")
    public @ResponseBody String update(@RequestParam String inventory_id, @RequestParam String film_id, @RequestParam String store_id) {
        // Vérifiez d'abord si l'inventaire avec cet ID existe
        int id = Integer.parseInt(inventory_id);
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);

        if (optionalInventory.isPresent()) {
            // Si l'inventaire existe, supprimez-le
            Inventory inventory = optionalInventory.get();

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            inventory.setFilm_id(Integer.parseInt(film_id));
            inventory.setStore_id(Integer.parseInt(store_id));
            inventory.setLast_update(timestamp);
            inventoryRepository.save(inventory);
            return "Update successful";
        } else {
            // Si l'inventaire n'existe pas, renvoyez un message approprié
            return "Inventory not found";
        }
    }

}