/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *
 * @author hayar.abderrafia
 */
public class Expense {
    private int id;
    private String description;
    private float price;
    private String type;

    public Expense(int id, String description, float price, String type) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.type = type;
    }
    public Expense( String description, float price, String type) {
        
        this.description = description;
        this.price = price;
        this.type = type;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Costs{" + "id=" + id + ", description=" + description + ", price=" + price + ", type=" + type + '}';
    }
    
}
