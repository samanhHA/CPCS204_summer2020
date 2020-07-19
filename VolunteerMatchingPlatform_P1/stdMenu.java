package VolunteerMatchingPlatform;

import java.io.*;
import java.util.*;

public class stdMenu {

    static VolunteerMatchingPlatform validVolu = new VolunteerMatchingPlatform();
    static VolunteerMatchingPlatform validProj = new VolunteerMatchingPlatform();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //declaring files && Scanners  
        File inputVolunteer = new File("volunteers.txt");
        File inputProject = new File("projects.txt");

        //check if file exist or not
        if (!inputVolunteer.exists() || !inputProject.exists()) {
            System.out.println("Sorry! File Not Found ");
            System.exit(0);

        }

        Scanner skip = new Scanner(System.in);  //scanner for optional information so i can easily use nextLine() without messing the rest 
        Scanner inputV = new Scanner(inputVolunteer); //Scanner for volunteers file
        inputV(inputV); //read && store data from volunteer file 
        Scanner inputP = new Scanner(inputProject);//Scanner for projects file
        inputP(inputP);//read && store data from project file
        Scanner userInput = new Scanner(System.in);// Scanner to read user input 

        int choice;

        do {
            System.out.print("1. Add a new volunteer"
                    + "\n2. Add a new project"
                    + "\n3. Print volunteer list with a vaild account"
                    + "\n4. Print 'not started' project list"
                    + "\n5. Search projects for volunteer"
                    + "\n6. Remove project by project Id"
                    + "\n7. Exit"
                    + "\nEnter your choice: ");
            choice = userInput.nextInt();
            System.out.println("\n");

            if (choice == 1) {
                addVolunteer(userInput, skip);
            } else if (choice == 2) {
                addProject(userInput);
            } else if (choice == 3) {
                validVolu.printValidVolunteerList();
            } else if (choice == 4) {
                validProj.printNotStartedProjects();
            } else if (choice == 5) {
                searchProject(skip);
            } else if (choice == 6) {
                removeProject(userInput);
            }

        } while (choice != 7);
        if (choice == 7) {
            System.exit(0);
        }

    }

    public static void inputV(Scanner inputV) {

        String skip = inputV.nextLine();  //skip first line 
        while (inputV.hasNext()) {

            String[] vol = inputV.nextLine().split(",");

            String psName = vol[0].replace(",", " ").trim();
            String name = vol[1].replace(",", " ").trim();
            String email = vol[2].replace(",", " ").trim();
            String phone = vol[3].replace(",", " ").trim();
            String skill = vol[4].replace(",", " ").trim();
            String exp = vol[5].replace(",", " ").trim();
            Integer experience = Integer.parseInt(exp);

            //projects
            int[] prevProj = new int[3];

            try {
                prevProj[0] = Integer.parseInt(vol[6].replace(",", " ").trim());
                prevProj[1] = Integer.parseInt(vol[7].replace(",", " ").trim());
                prevProj[2] = Integer.parseInt(vol[8].replace(",", " ").trim());
                prevProj[2] = Integer.parseInt(vol[8].replace("#", " ").trim());
            } catch (NumberFormatException ex) {

            }

            //check validity (has email OR phone number)
            if (!email.isEmpty() || !phone.isEmpty()) {

                Volunteer inputVolunteer = new Volunteer(psName, name, email, phone, skill, experience, prevProj);
                validVolu.insertVolunteer(inputVolunteer);

            }

        }
    }

    public static void addVolunteer(Scanner userInput, Scanner skip) throws IOException {
        System.out.println("Please enter the volunteer information:\n");
        System.out.print("PseudoName: ");
        String psName = userInput.next();
        if (validVolu.checkPseudoName(psName)) {
            System.out.println("\nThe volunteer already exists!\n");
        } else {

            System.out.print("Name: ");
            String name = userInput.next();
            System.out.print("Email: ");
            String email = skip.nextLine();
            System.out.print("Phone: ");
            String phone = skip.nextLine();
            System.out.print("Skills: ");
            String skills = userInput.next();
            System.out.print("Experience:");
            int expe = userInput.nextInt();

            //projects  
            int[] prevProj = new int[3];
            System.out.print("Project-ID-1:");
            prevProj[0] = userInput.nextInt();
            System.out.print("Project-ID-2:");
            String temp1 = skip.nextLine();
            if (!temp1.isEmpty()) {
                prevProj[1] = Integer.parseInt(temp1);
                System.out.print("Project-ID-3:");
                String temp2 = skip.nextLine();
                if (!temp2.isEmpty()) {
                    prevProj[2] = Integer.parseInt(temp2);
                }
            }

            //check the validity of the account 
            if (!email.isEmpty() || !phone.isEmpty()) {
                Volunteer newVolunteer = new Volunteer(psName, name, email, phone, skills, expe, prevProj);
                validVolu.insertVolunteer(newVolunteer);
                System.out.println("\nThe volunteer is added!\n");

                //append the new volunteer to the txt file
                PrintWriter outputV = new PrintWriter(new BufferedWriter(new FileWriter("volunteers.txt", true)));
                outputV.println(newVolunteer.toString());
                outputV.flush();
                outputV.close();
            }

        }

    }

    public static void inputP(Scanner inputP) {
        String skip = inputP.nextLine();  //skip first line 
        while (inputP.hasNext()) {

            //spliti && replace all comma with space 
            String[] proj = inputP.nextLine().split(",");
            String projID = proj[0].replace(",", " ").trim();
            String organization = proj[1].replace(",", " ").trim();
            String title = proj[2].replace(",", " ").trim();
            String description = proj[3].replace(",", " ").trim();
            String category = proj[4].replace(",", " ").trim();
            String sta = proj[5].replace(",", " ").trim();
            String status = proj[5].replace("#", " ").trim();

            Project newProj = new Project(projID, organization, title, description, category, status);
            //check id validity 
            if (validProj.checkProjectID(projID)) {
                System.out.println("\nThis project already exist!\n");
            } else {
                validProj.insertProject(newProj);
            }

        }

    }

    public static void addProject(Scanner userInput) throws IOException {
        System.out.println("Please enter the project information:\n");
        System.out.print("Project Id: ");
        String projID = userInput.next();
        //check ID
        if (validProj.checkProjectID(projID)) {
            System.out.println("\nThis project already exists!\n");
        } else {
            System.out.print("Company: ");
            String company = userInput.next();
            System.out.print("Title: ");
            String title = userInput.next();
            System.out.print("Description: ");
            String description = userInput.next();
            System.out.print("Category: ");
            String category = userInput.next();

            Project newProj = new Project(projID, company, title, description, category, "not started");

            validProj.insertProject(newProj);
            System.out.println("\nThe project is added!\n");

            //append it to the file 
            PrintWriter outputP = new PrintWriter(new BufferedWriter(new FileWriter("projects.txt", true)));
            outputP.println(newProj.toString());
            outputP.flush();
            outputP.close();

        }

    }

    public static void searchProject(Scanner input) {

        System.out.print("Please enter the information related to the project"
                + "\nskill: ");
        String skill = input.nextLine();
        System.out.println("\n");
        validProj.searchByCategory(skill);

    }

    public static void removeProject(Scanner input) {
        System.out.print("Please enter the projectID of the project to be deleted:"
                + "\nProject Id: ");
        String projId = input.next();
        int intProjID = Integer.parseInt(projId);   //there're two variable because (as it is the requirements in the assignment doc) projectID is a String variable, but the array of prevProject of the volunteer is an int Type

        //check if it can be removed or not. The project cannot be removed if it's assigned to a volunteer 
        if (validVolu.removable(intProjID) == true) { //it can be removed

            validProj.removeProject(projId);
            System.out.println("\nThe project has been deleted!\n");

        } else {
            System.out.println("\nThis project cannot be deleted!\n");
        }

    }

}
