package Tests;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */

import junit.framework.TestCase;
import cntr.*;
import junit.framework.Assert;
import org.junit.Test;
import pkg1.Expense;



/**
 *
 * @author hayar.abderrafia
 */
public class ModelTest extends TestCase{
    Model model;
    Expense expense;
    String dni;
    public ModelTest() {
        setUp();
    }
    
    @Override
    public void setUp(){
    model=new Model();
    expense=new Expense(11,"Light fee",58,"Maintenance");
    dni="111111111D";
    }

    @Test
    public void testaddExpense(){
    
    int result = Model.addExpense(expense);
    
    Assert.assertEquals(1,result);
    }
    
    public void testUnsuscribe(){
    
    int result = Model.unsuscribePF(dni);
    
    Assert.assertEquals(1,result);
    }
    
   
}
