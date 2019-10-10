package net.apptamm.tamm.model;

public class AreaItem {

    private String areaName;
    private int areaId;
    private int areaIdParent;

    public AreaItem() {
    }

    public AreaItem(String areaName, int areaId, int areaIdParent) {
        this.areaName = areaName;
        this.areaId = areaId;
        this.areaIdParent = areaIdParent;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getAreaIdParent() {
        return areaIdParent;
    }

    public void setAreaIdParent(int areaIdParent) {
        this.areaIdParent = areaIdParent;
    }
}
