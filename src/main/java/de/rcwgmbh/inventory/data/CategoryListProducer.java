package de.rcwgmbh.inventory.data;

import de.rcwgmbh.inventory.model.Category;
import de.rcwgmbh.inventory.services.CategoryService;
import de.rcwgmbh.inventory.util.Events.Added;
import de.rcwgmbh.inventory.util.Events.Deleted;
import de.rcwgmbh.inventory.util.Events.Updated;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jalexakis
 */
@RequestScoped
public class CategoryListProducer {
    
    private List<Category> categories;
    
    @Inject
    private CategoryService categoryService;
    
    @PostConstruct
    public void init(){
        categories = categoryService.getAllCategories();
    }
    
    @Produces
    @Named
    public List<Category> getCategories(){
        return categories;
    }
    
    
    public void onCategoryAdded(@Observes @Added Category category) {
        categoryService.addCategory(category);
        init();
    }

    public void onCategoryDeleted(@Observes @Deleted Category category) {
        categoryService.deleteCategory(category);
        init();
    }

    public void onAktionUpdated(@Observes @Updated Category category) {
        categoryService.updateCategory(category);
        init();
    }
}
