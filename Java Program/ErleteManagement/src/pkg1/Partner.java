/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *This is the class which saves de members information
 * @author hayar.abderrafia
 */
public class Partner {
    private String DNI;
    private String name;
    private String surname;
    private boolean active;
    
/**
 * This is the constructor to create a partner
 * @param DNI. This parameter saves the DNI of the partner
 * @param name. This parameter saves the name of the partner
 * @param surname. This parameter saves the surname of the partner
 * @param active
 */
    public Partner(String DNI, String name, String surname, boolean active) {
        this.DNI = DNI;
        this.name = name;
        this.surname = surname;
        this.active = active;
    }
    
    /**
     * This is the DNI getter
     * @return. Returns the DNI
     */
    public String getDNI() {
        return DNI;
    }
    
    /**
     * This is the DNI setter
     * @param DNI. This parameter saves the DNI 
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    
    /**
     * This is the name getter
     * @return  Returns the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * This is the name setter
     * @param name. This parameter saves the name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is the surname getter
     * @return Returns the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * This is the surname setter
     * @param surname This parameter saves the surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    

    
}
