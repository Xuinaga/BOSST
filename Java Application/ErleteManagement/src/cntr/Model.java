/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cntr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pkg1.Expense;
import pkg1.PartnershipFee;
import pkg1.ProductionFee;

/**
 *
 * @author hayar.abderrafia
 */
public class Model {

    private static Connection connect() {
        // SQLite connection string

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/erlete_db", "abde", "abde");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;

    }

    public static void addExpense(Expense ex) {
        String sql = "INSERT INTO Expense(description,price,expense_type) VALUES(?,?,?)";

        
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1,ex.getDescription());
            pstmt.setFloat(2,ex.getPrice());
            pstmt.setString(3,ex.getType());

             pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }

    public static ArrayList<Expense> showExpense() {
        ArrayList<Expense> Expenses = new ArrayList<>();
        String taula = "Expense";
        String sql = "SELECT * FROM " + taula;

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Expense e = new Expense (rs.getInt("id_expense"),rs.getString("description"),rs.getFloat("price"),rs.getString("expense_type"));
                Expenses.add(e);
            }
        } catch (Exception a) {
            System.out.println(a.getMessage());
        }
        return Expenses;
    }

    public static ArrayList<ProductionFee> showProductionFee() {
        ArrayList<ProductionFee> ProductionFee = new ArrayList<>();
        String taula = "Production_fee";
        String sql = "SELECT * FROM " + taula;

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ProductionFee f = new ProductionFee (rs.getString("partner_DNI"),rs.getString("month"),rs.getInt("year"),rs.getFloat("total_price"));
                ProductionFee.add(f);
            }
        } catch (Exception a) {
            System.out.println(a.getMessage());
        }
        return ProductionFee;
    }

    public static void addProductionFee(ProductionFee p) {
        String sql = "INSERT INTO Production_fee(partner_DNI,month,year,total_price) VALUES(?,?,?,?)";

        
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,p.getDNI());
            pstmt.setString(2,p.getMonth());
            pstmt.setInt(3,p.getYear());
            pstmt.setFloat(4,p.getPrice());

             pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }

    }

    public static ArrayList<PartnershipFee> showPartnershipFee() {
        ArrayList<PartnershipFee> PartnershipFee = new ArrayList<>();
        String taula = "Partnership_fee";
        String sql = "SELECT * FROM " + taula;

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                PartnershipFee p = new PartnershipFee (rs.getString("partner_DNI"),rs.getInt("year"),rs.getBoolean("fee_charged"));
                PartnershipFee.add(p);
            }
        } catch (Exception a) {
            System.out.println(a.getMessage());
        }
        return PartnershipFee;
    }
    
    public static void payPartnershipFee(String partner_DNI) {
        String sql = "UPDATE partnership_fee SET fee_charged = 1 "
                + "WHERE partner_DNI = ?"
                + "AND fee_charged= 0";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, partner_DNI);
           

            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void unsuscribe(String dni) {
        String sql = "DELETE FROM partnership_fee WHERE partner_DNI = ?";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, dni);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
