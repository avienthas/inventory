package de.rcwgmbh.inventory.services;

import de.rcwgmbh.inventory.model.Category;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author jalexakis
 */
@Stateless
public class CategoryServiceBean implements CategoryService {
    @Inject
    EntityManager entityManager;

    @Override
    public List<Category> getAllCategories() {
        TypedQuery<Category> query = entityManager.createNamedQuery(Category.findAll, Category.class);
        List<Category> categories = query.getResultList();
        categories.forEach(category -> category.getAmountOfItems());
        return categories;
    }

    @Override
    public Category getCategory(String name) {
        Category category = entityManager.find(Category.class, name);
        return category;
    }

    @Override
    public void addCategory(Category category) {
        entityManager.persist(category);
    }

    @Override
    public void deleteCategory(Category category) {
        entityManager.remove(category);
    }

    @Override
    public void updateCategory(Category category) {
        entityManager.merge(category);
    }
    
}
