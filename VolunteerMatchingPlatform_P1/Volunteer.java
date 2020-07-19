package VolunteerMatchingPlatform;

public class Volunteer {

    private String pseudoName, name, email, phone, skills;
    private int experience;
    private int[] prevProject = new int[3];  
    private Volunteer next;

    public Volunteer(String pseudoName, String name, String email, String phone, String skills, int experience, int[] prevProject, Volunteer next) {
        this.pseudoName = pseudoName;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.skills = skills;
        this.experience = experience;
        this.prevProject = prevProject;
        this.next = next;

    }

    public Volunteer(String pseudoName, String name, String email, String phone, String skills, int experience, int[] prevProject) {
        this.pseudoName = pseudoName;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.skills = skills;
        this.experience = experience;
        this.prevProject = prevProject;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setPrevProject(int[] prevProject) {
        this.prevProject = prevProject;
    }

    public int[] getPrevProject() {
        return prevProject;

    }

    public String getPseudoName() {
        return pseudoName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getSkills() {
        return skills;
    }

    public int getExperience() {
        return experience;
    }

    public Volunteer getNext() {
        return next;
    }

    public void setPseudoName(String pseudoName) {
        this.pseudoName = pseudoName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setNext(Volunteer next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return pseudoName + "," + name + "," + email + "," + phone + "," + skills + "," + experience + "," + prevProject[0] + "," + prevProject[1] + "," + prevProject[2] + "#";
    }

}
