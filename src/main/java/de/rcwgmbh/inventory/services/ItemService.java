package de.rcwgmbh.inventory.services;

import de.rcwgmbh.inventory.model.Category;
import de.rcwgmbh.inventory.model.Item;
import java.util.List;

/**
 *
 * @author jalexakis
 */
public interface ItemService {
   List<Item> getItemsList(Category name);
}
