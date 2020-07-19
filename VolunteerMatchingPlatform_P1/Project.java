package VolunteerMatchingPlatform;

public class Project {

    private String projectId, organization, title, description, category, stauts;
    //private String [3] status; 

    private Project next;

    public Project(String projectId, String organization, String title, String description, String category, String stauts, Project next) {
        this.projectId = projectId;
        this.organization = organization;
        this.title = title;
        this.description = description;
        this.category = category;
        this.stauts = stauts;
        this.next = next;
    }

    public Project(String projectId, String organization, String title, String description, String category, String stauts) {
        this.projectId = projectId;
        this.organization = organization;
        this.title = title;
        this.description = description;
        this.category = category;
        this.stauts = stauts;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setNext(Project next) {
        this.next = next;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getOrganization() {
        return organization;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Project getNext() {
        return next;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    @Override
    public String toString() {
        return projectId + "," + organization + "," + title + "," + description + "," + category + "," + stauts + "#";
    }

}
