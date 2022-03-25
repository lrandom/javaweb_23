package com.niit.java23.dals;

import com.niit.java23.models.Categories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DalCategory extends DB implements IDal<ArrayList<Categories>, Categories> {
    private int pageSize = DB.PAGE_SIZE;
    public DalCategory() {
        super();//gọi constructor của cha //kết nối đến DB
        this.setTableName("categories");
    }

    public void setSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    @Override
    public ArrayList<Categories> getRows(int page) {
        int offset = (page - 1) * this.getPageSize();
        ArrayList<Categories> categories = new ArrayList<>();
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM " + this.getTableName() + " ORDER BY id DESC " + " LIMIT " + offset + "," + this.getPageSize());
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
        return true;
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

    @Override
    public Categories getRow(long id) {
        try {
            Statement stm = this.connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM " + this.getTableName() + " WHERE id=" + id);
            rs.next();
            Categories c = new Categories();
            c.setId(rs.getLong("id"));
            c.setName(rs.getString("name"));
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
