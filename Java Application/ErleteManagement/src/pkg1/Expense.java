/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *This class 
 * @author hayar.abderrafia
 */
public class Expense {
    private int id;
    private String description;
    private float price;
    private String type;
    
    /**
     * This is the constructor of the class
     * @param id. This parameter saves the id
     * @param description. This parameter saves the description
     * @param price. This parameter saves the price
     * @param type. This parameter saves the type
     */
    public Expense(int id, String description, float price, String type) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.type = type;
    }
    /**
     * This is another constructor
     * @param description. This parameter saves the description
     * @param price. This parameter saves the price
     * @param type. This parameter saves the type
     */
    public Expense( String description, float price, String type) {
        
        this.description = description;
        this.price = price;
        this.type = type;
    }
    /**
     * This is the Id getter
     * @return 
     */
    public int getId() {
        return id;
    }
    
    /**
     * This is the Id setter
     * @param id . This parameter saves the dat
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * This is the description getter
     * @return 
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * This is the description setter
     * @param description . This parameter saves the dat
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * This is the price getter
     * @return 
     */
    public float getPrice() {
        return price;
    }
    
    /**
     * This is the price setter
     * @param price . This parameter saves the dat
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
    /**
     * This is the type getter
     * @return 
     */
    public String getType() {
        return type;
    }
    
    /**
     * This is the type setter
     * @param type . This parameter saves the dat
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * This is the toString method
     * @return 
     */
    @Override
    public String toString() {
        return "Costs{" + "id=" + id + ", description=" + description + ", price=" + price + ", type=" + type + '}';
    }
    
}
