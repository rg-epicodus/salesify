package models;

import java.time.LocalDateTime;

/**
 * Created by Guest on 8/23/17.
 */
public class CatItems extends Items {
    private String name;
    private String description;
    private int itemId;
    private int id;

    public CatItems(boolean isOnSale, double price, String name) {
        super(isOnSale, price);
        this.name = name;
        this.description = description;
        this.itemId = itemId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CatItems catItems = (CatItems) o;

        if (itemId != catItems.itemId) return false;
        if (id != catItems.id) return false;
        if (!name.equals(catItems.name)) return false;
        return description != null ? description.equals(catItems.description) : catItems.description == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + itemId;
        result = 31 * result + id;
        return result;
    }
}
