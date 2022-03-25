package com.niit.java23.dals;

import com.niit.java23.models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DalProduct extends DB implements IDal<ArrayList<Product>, Product> {
    public DalProduct() {
        super();//gọi constructor của cha //kết nối đến DB
        this.setTableName("categories");
    }

    @Override
    public ArrayList<Product> getRows(int page) {
        int offset = (page - 1) * DB.PAGE_SIZE;
        ArrayList<Product> products = new ArrayList<>();
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM " + this.getTableName() + " ORDER BY id DESC " + " LIMIT " + offset + "," + DB.PAGE_SIZE);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setImage(rs.getString("image"));
                product.setDescription(rs.getString("description"));
                product.setCategoryId(rs.getLong("category_id"));
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product getRow(long id) {
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM " + this.getTableName() + " WHERE id=" + id);
            rs.next();
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setName(rs.getString("name"));
            product.setCategoryId(rs.getLong("category_id"));
            product.setPrice(rs.getDouble("price"));
            product.setImage(rs.getString("image"));
            product.setDescription(rs.getString("description"));
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addRow(Product o) {
        try {
            PreparedStatement prp = this.connection
                    .prepareStatement("INSERT INTO " + this.getTableName() + " (name,price,image,description,category_id) VALUES (?,?,?,?,?)");
            prp.setString(1, o.getName());
            prp.setDouble(2, o.getPrice());
            prp.setString(3, o.getImage());
            prp.setString(4, o.getDescription());
            prp.setLong(5, o.getCategoryId());
            prp.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteRow(Product o) {
        try {
            PreparedStatement prp = this.connection
                    .prepareStatement("DELETE FROM " + this.getTableName() + " WHERE id=?");
            prp.setLong(1, o.getId());
            prp.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateRow(Product o) {
        try {
            PreparedStatement prp = this.connection
                    .prepareStatement("UPDATE " + this.getTableName() + " SET name=?,price=?,image=?,description=?,category_id=? WHERE id=?");
            prp.setString(1, o.getName());
            prp.setDouble(2, o.getPrice());
            prp.setString(3, o.getImage());
            prp.setString(4, o.getDescription());
            prp.setLong(5, o.getCategoryId());
            prp.setLong(6, o.getId());
            prp.execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public int getTotalRows() {
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(*) AS total_rows FROM " + this.getTableName());
            rs.next();
            return rs.getInt("total_rows");
        } catch (Exception e) {
            return 0;
        }
    }
}
