package de.rcwgmbh.inventory.services;

import de.rcwgmbh.inventory.model.Category;
import java.util.List;

/**
 *
 * @author jalexakis
 */
public interface CategoryService {
    List<Category> getAllCategories();
    
    Category getCategory(String name);

    public void addCategory(Category category);

    public void deleteCategory(Category category);

    public void updateCategory(Category category);
}
