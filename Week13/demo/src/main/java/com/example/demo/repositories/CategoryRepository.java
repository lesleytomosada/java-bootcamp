package com.example.demo.repositories;

import com.example.demo.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private DataSource dataSource;

    //get all categories
    public List<Category> getAllCategories(){
        //write your sql query
        //open a connection to the database
        //we are going to prepare the query to be sent to SQL
        //we will execute he query and get back a result st
        //loop through each row in the result set
        //grab data column by column and put it into a new Java obect
        //put it in a list
        //at the end of the loop, return the list
        String query = "SELECT * FROM categories";
        List<Category> categories = new ArrayList<>();

        //try-with
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
            //grab the data from the columns
            Category c = mapRowToCategory(rs);
            categories.add(c);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();;
        }
        return categories;
    }

    public Optional<Category> getCategoryById(int id){
        String query = "SELECT * FROM categories WHERE category_id = ?";
        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return Optional.of(mapRowToCategory(rs));
                }
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();;
        }
        return Optional.empty();
     }


     public void deleteCategory(int id){
        String query = "DELETE FROM categories WHERE category_id = ?";
        try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.executeUpdate();
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
     }

     public int createCategory(Category category){
        String query = "INSERT INTO categories (category_name, description) VALUES (?, ?) RETURNING category_id";
        int generatedId = -1;

        try(Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)
        ){
            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getDescription());

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    generatedId=rs.getInt(1);
                }
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        return generatedId;
     }

     public void updateCategory(Category category){
        String query = "UPDATE categories SET category_name = ?, description = ? WHERE category_id = ?";
        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){
         ps.setString(1, category.getCategoryName());
         ps.setString(2, category.getDescription());
         ps.setInt(3, category.getCategoryId());

         ps.executeUpdate();
        }
        catch(SQLException ex) {
            ex.printStackTrace();;
        }
     }

     private Category mapRowToCategory(ResultSet rs) throws SQLException {
         int categoryId = rs.getInt("category_id");
         String categoryName = rs.getString("category_name");
         String description = rs.getString("description");
         return new Category(categoryId, categoryName, description);
     }
}
