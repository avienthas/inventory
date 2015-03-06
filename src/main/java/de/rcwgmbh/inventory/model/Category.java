package de.rcwgmbh.inventory.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jalexakis
 */
@NamedQueries({
    @NamedQuery(name = Category.findAll, query = "SELECT c FROM Category c ORDER BY c.name"),
    @NamedQuery(name = Category.findByName, query = "SELECT c FROM Category c WHERE c.name = :name")
})

@Entity
public class Category {

    public static final String findAll = "Category.findAll";
    public static final String findByName = "Category.findByName"; 

    @NotNull
    @Id
    @Size(min = 4, max = 30, message = "{category.name.size}")   
    private String name;

    @OneToMany(mappedBy = "category")   
    private List<Item> items;

    @Transient
    private int amountOfItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getAmountOfItems() {
        setAmountOfItems(items.size());
        return amountOfItems;
    }

    public void setAmountOfItems(int amountOfItems) {
        this.amountOfItems = amountOfItems;
    }

}
