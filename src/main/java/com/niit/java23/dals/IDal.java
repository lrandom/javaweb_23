package com.niit.java23.dals;

public interface IDal<C, O> {
    public C getRows();

    public boolean addRow(O o);

    public boolean deleteRow(O o);

    public boolean updateRow(O o);
}
