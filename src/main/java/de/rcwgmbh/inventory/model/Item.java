package de.rcwgmbh.inventory.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jalexakis
 */
@NamedQueries({
    @NamedQuery(name = Item.findAll, query = "SELECT i FROM Item i ORDER BY i.category"),
    @NamedQuery(name = Item.findByCategory, query = "SELECT i FROM Item i WHERE i.category = :category")
})

@Entity
public class Item {

    public static final String findAll = "Item.findAll";
    public static final String findByCategory = "Item.findByCategory";

    @GeneratedValue
    @Id
    private Long id;

    private String internalId;
   
    private String manufacturer;
    
    private String model;

    private String serialNumber;

    private byte[] photo;

    private String vendor;

    @Temporal(TemporalType.DATE)
    private Date dateOfPurchase;
    
    @ManyToOne
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }    

}
