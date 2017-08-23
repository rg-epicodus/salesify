package models;

import java.time.LocalDateTime;

/**
 * Created by Guest on 8/23/17.
 */
public class DogItems {
    private String name;
    private String description;
    private float price;
    private LocalDateTime purchasedAt;
    private int itemId;
    private int id;

    public DogItems(String name, String description, float price, LocalDateTime purchasedAt, int itemId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.purchasedAt = purchasedAt;
        this.itemId = itemId;
    }
}
