package de.rcwgmbh.inventory.controller;

import de.rcwgmbh.inventory.data.CategoryProducer;
import de.rcwgmbh.inventory.model.Category;
import de.rcwgmbh.inventory.model.Item;
import de.rcwgmbh.inventory.services.ItemService;
import de.rcwgmbh.inventory.util.Events.Added;
import de.rcwgmbh.inventory.util.Events.Updated;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author jalexakis
 */
@ViewScoped
@Named
public class ListCategoriesController implements Serializable {

    private static final long serialVersionUID = -2347239478324L;

    @Inject
    private EntityManager entityManager;
    @Inject
    private CategoryProducer categoryProducer;
    @Inject
    private ItemService itemService;
    @Inject
    @Added
    private Event<Category> categoryAddEvent;

    @Inject
    @Updated
    private Event<Category> categoryUpdateEvent;

    public String doListItems(Category category) {
        final List<Item> items = itemService.getItemsList(category);
        category.setItems(items);
        categoryProducer.setSelectedCategory(category);
        return Pages.LIST_CATEGORIES;
    }

    public String doAddCategory() {
        categoryProducer.prepareAddCategory();
        return Pages.LIST_CATEGORIES;
    }

    public String doEditCategory(Category category) {
        categoryProducer.prepareEditCategory(category);
        return Pages.LIST_CATEGORIES;
    }

    public String doSave() {
        if (categoryProducer.isAddMode()) {
            categoryAddEvent.fire(categoryProducer.getSelectedCategory());
        } else {
            categoryUpdateEvent.fire(categoryProducer.getSelectedCategory());
        }
        return Pages.LIST_CATEGORIES;
    }

    public void onTabChange(TabChangeEvent event) {
        String categoryName = event.getTab().getTitle();
        Category category = entityManager.find(Category.class, categoryName);
        categoryProducer.setSelectedCategory(category); 
        System.out.println("Active tab changed");
    }  

}
