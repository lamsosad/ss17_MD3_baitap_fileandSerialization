package bai2_copyfile_nhiphan;

import java.io.Serializable;

public class Products implements Serializable {
    private int id;
    private String name;
    private String producer;
    private double price;
    private String title;

    public Products() {
    }

    public Products(int id, String name, String producer, double price, String title) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Product[" +
                "id= " + id +
                ", name= '" + name + "\' " +
                ", producer= '" + producer + "\' " +
                ", price= " + price +
                ", title= '" + title + "\' " +
                "]";
    }
}
