package VolunteerMatchingPlatform;

public class VolunteerMatchingPlatform {

    private Volunteer headFL;
    private Project headPL;

    public Volunteer getHeadFL() {
        return headFL;
    }

    public Project getHeadPL() {
        return headPL;
    }

    public void setHeadFL(Volunteer headFL) {
        this.headFL = headFL;
    }

    public void setHeadPL(Project headPL) {
        this.headPL = headPL;
    }

    //return true if the projectID exist 
    public boolean checkProjectID(String ID) {

        Project pointer = headPL;
        while (pointer != null) {
            if (pointer.getProjectId().equalsIgnoreCase(ID)) {
                return true;
            }

            pointer = pointer.getNext();
        }
        return false;

    }

    //return true if the psName exist 
    public boolean checkPseudoName(String psName) {

        Volunteer pointer = headFL;
        while (pointer != null) {
            if (pointer.getPseudoName().equalsIgnoreCase(psName)) {
                return true; //it means this psname is already exist 
            }

            pointer = pointer.getNext();
        }
        return false;
    }

    public void printValidVolunteerList() {
        Volunteer pointer = headFL;
        System.out.println("Pseudo\t\tName\t\tEmail\t\t\t Phone\t\tSkills\t\t\tExp.\tPjct-Id1\tPrjct-Id2\tPrjct-Id3");
        while (pointer != null) {
            System.out.printf("%-16s%-16s%-25s%-15s%-25s%-9d", pointer.getPseudoName(), pointer.getName(), pointer.getEmail(),
                    pointer.getPhone(), pointer.getSkills(), pointer.getExperience());

            for (int i = 0; i < 3; i++) {
                System.out.print(pointer.getPrevProject()[i] + "\t\t");

            }

            pointer = pointer.getNext();
            System.out.println("\n");
        }
        System.out.println("\n");

    }

    public void printNotStartedProjects() {
        Project pointer = headPL;
        System.out.println("Project Id\tcompany\t\ttitle\t\t\t   description\t\t\t\t category       \t    status");

        while (pointer != null) {
            if (pointer.getStauts().equalsIgnoreCase("not started")) {
                System.out.printf("%-16s%-16s%-27s%-38s%-25s%-12s%n", pointer.getProjectId(),
                        pointer.getOrganization(), pointer.getTitle(), pointer.getDescription(), pointer.getCategory(), pointer.getStauts());
                System.out.println("\n");
            }

            pointer = pointer.getNext();

        }
        System.out.println("\n");
    }

    //to add a new Node to volunteer linkedList
    public void insertVolunteer(Volunteer newvol) {

        if (headFL == null) {
            headFL = newvol;
        } else {
            Volunteer pointer = headFL;
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }

            //insert the new node 
            pointer.setNext(newvol);
        }

    }

    //to add a new Node to Project linkedList
    public void insertProject(Project newProj) {

        if (headPL == null) {
            headPL = newProj;
        } else {
            Project pointer = headPL;
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }

            //insert the new node
            pointer.setNext(newProj);
        }
    }

    //when user enter his/her skill, this method search a match in project linkedlist 
    public void searchByCategory(String vSkill) {
        Project pointer = headPL;
        System.out.println("Project Id\tcompany\t\ttitle\t\t\t   description\t\t\t\t category       \t    status");

        while (pointer != null) {
            if (pointer.getCategory().contains(vSkill)) {
                System.out.printf("%-16s%-16s%-27s%-38s%-25s%-12s%n", pointer.getProjectId(),
                        pointer.getOrganization(), pointer.getTitle(), pointer.getDescription(), pointer.getCategory(), pointer.getStauts());
            }

            pointer = pointer.getNext();

        }

        System.out.println("\n");

    }

    //to check if the project is assigned to a volunteer or not 
    public boolean removable(int projID) {

        Volunteer pointer = headFL;
        while (pointer != null) {
            for (int i = 0; i < pointer.getPrevProject().length; i++) {
                if (pointer.getPrevProject()[i] == projID) {
                    return false;  //it cannot be removed because it's assigned to a volunteer
                }
            }
            pointer = pointer.getNext();
        }

        return true;
    }

    //after checking whether the project removable or not, this method to delete the node from project linkedlist 
    public void removeProject(String projID) {
        Project pointer = headPL;
        if (headPL.getProjectId().equals(projID)) {
            headPL = headPL.getNext();
        } else {
            while (pointer.getNext() != null) {
                if (pointer.getNext().getProjectId().equals(projID)) {
                    pointer.setNext(pointer.getNext().getNext());
                    break;
                }
                pointer = pointer.getNext();
            }
        }
    }

}
