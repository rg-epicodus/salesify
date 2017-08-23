package models;

import java.time.LocalDateTime;

/**
 * Created by Guest on 8/23/17.
 */
public class DogItems extends Items {

    private String name;
    private String description;
    private int itemId;
    private int id;

    public DogItems(boolean isOnSale, double price, String name, LocalDateTime purchasedAt, int id) {
        super(isOnSale, price);
        this.name = name;
        this.description = description;
        this.itemId = itemId;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DogItems dogItems = (DogItems) o;

        if (itemId != dogItems.itemId) return false;
        if (id != dogItems.id) return false;
        if (!name.equals(dogItems.name)) return false;
        return description != null ? description.equals(dogItems.description) : dogItems.description == null;
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
