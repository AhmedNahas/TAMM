package net.apptamm.tamm.model;

public class PlanModel {
    private String title, description;

    public PlanModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public PlanModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
