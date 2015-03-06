package de.rcwgmbh.inventory.data;

import de.rcwgmbh.inventory.model.Category;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 *
 * @author jalexakis
 */
@SessionScoped
public class CategoryProducer implements Serializable {

    private static final long serialVersionUID = 4573987593475L;

    private enum Mode {

        EDIT, ADD
    }

    private Category category;
    private Mode mode;

    @Produces
    @Named
    public Category getSelectedCategory() {
        return category;
    }

    public void setSelectedCategory(Category category) {
        this.category = category;
    }

    @Produces
    @Named
    public boolean isAddMode() {
        return mode == Mode.ADD;
    }

    public void prepareAddCategory() {
        this.category = new Category();
        this.mode = Mode.ADD;
    }

    public void prepareEditCategory(Category category) {
        this.category = category;
        this.mode = Mode.EDIT;
    }

}
