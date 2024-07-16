package com.example.demo.repositories;

import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository {
    @Autowired
    private DataSource dataSource;

    public List<Product> getAllProducts(){
        String query = "SELECT * FROM products";
        List<Product> products = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery()) {
            ;

            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String name = rs.getString("product_name");
                double unitPrice = rs.getDouble("unit_price");
                int unitsInStock = rs.getInt("units_in_stock");
                Product product = new Product(productId, name, unitPrice, unitsInStock);
                products.add(product);
            }
        }
                catch (SQLException ex){
                    ex.printStackTrace();
            }
        return products;

    }

    public List<Product> getAllProductsByCategoryId(int categoryId){
        String query = "SELECT * FROM products WHERE category_id = ?";
        List<Product> products = new ArrayList<>();
        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, categoryId);
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    products.add(mapRowToProduct(rs));
                }
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();;
        }
        return products;
    }

    private Product mapRowToProduct(ResultSet rs) throws SQLException {
        int productId = rs.getInt("product_id");
        String productName = rs.getString("product_name");
        double unitPrice = rs.getDouble("unit_price");
        int unitsInStock = rs.getInt("units_in_stock");
        return new Product(productId, productName, unitPrice, unitsInStock);
    }
}
