package models;

import java.time.LocalDateTime;

/**
 * Created by Guest on 8/23/17.
 */
public class Items {
    private String name;
    private String address;
    private String zipcode;
    private String phone;
    private int id;

    public Items(String name, String address, String zipcode, String phone) {
        this.name = name;
        this.address = address;
        this.zipcode = zipcode;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Items items = (Items) o;

        if (!name.equals(items.name)) return false;
        if (address != null ? !address.equals(items.address) : items.address != null) return false;
        if (zipcode != null ? !zipcode.equals(items.zipcode) : items.zipcode != null) return false;
        return phone != null ? phone.equals(items.phone) : items.phone == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
