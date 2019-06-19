package net.middledleeast.tamm.model;

public class RegionItem {

    private String name;
    private  int id;
    private int idParent;

    public RegionItem(String name , int id , int idParent){
        this.name = name;
        this.id = id;
        this.idParent = idParent;
    }

    public RegionItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }
}
