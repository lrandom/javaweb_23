package com.niit.java23.dals;

import com.niit.java23.models.Categories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DalCategory extends DB implements IDal<ArrayList<Categories>, Categories> {
    public DalCategory() {
        super();//gọi constructor của cha //kết nối đến DB
        this.setTableName("categories");
    }

    @Override
    public ArrayList<Categories> getRows() {
        ArrayList<Categories> categories = new ArrayList<>();
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM " + this.getTableName());
            while (rs.next()) {
                Categories c = new Categories();
                c.setId(rs.getLong("id"));
                c.setName(rs.getString("name"));
                categories.add(c);
            }
            return categories;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addRow(Categories o) {
        try {
            PreparedStatement prp = this.connection
                    .prepareStatement("INSERT INTO " + this.getTableName() + " (name) VALUES (?)");
            prp.setString(1, o.getName());
            prp.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteRow(Categories o) {
        try {
            PreparedStatement prp = this.connection
                    .prepareStatement("DELETE FROM " + this.getTableName() + " WHERE id=?");
            prp.setLong(1, o.getId());
            prp.execute();
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean updateRow(Categories o) {
        try {
            PreparedStatement prp = this.connection
                    .prepareStatement("UPDATE " + this.getTableName() + " SET name=? WHERE id=?");
            prp.setString(1, o.getName());
            prp.setLong(2, o.getId());
            prp.execute();
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
