package de.rcwgmbh.inventory.services;

import de.rcwgmbh.inventory.model.Category;
import de.rcwgmbh.inventory.model.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author jalexakis
 */
@Stateless
public class ItemServiceBean implements ItemService {
    @Inject
    EntityManager entityManager;

    @Override
    public List<Item> getItemsList(Category name) {
        Query query = entityManager.createNamedQuery(Item.findByCategory, Item.class)
                .setParameter("category", name);
        List<Item> items = query.getResultList();
        return items;
    }
    
}
