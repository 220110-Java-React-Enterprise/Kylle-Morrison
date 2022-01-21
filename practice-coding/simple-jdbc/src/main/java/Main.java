import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        //we need to store the database credentials safely and securely
        //we need connection to mariaDB
        //we will need an interface for CRUD
        //we will implement this interface on your repos

        Connection conn = ConnectionManager.getConnection();

        AssociateModel kai = new AssociateModel(1, "Kai", "Morrison", 18);
        AssociateModel tiffany = new AssociateModel(2, "Tiffany", "Obi", 25);
        AssociateModel kyle = new AssociateModel(3, "Kyle", "Plummer", 36);
        AssociateModel cody = new AssociateModel(4, "Cody", "Gonsowski", 22);
        AssociateModel stefan = new AssociateModel(5, "Stefan", "Riley", 29);
        AssociateModel shabana = new AssociateModel(6, "Shabana", "Mehr", 35);

        AssociateRepo repo = new AssociateRepo();

        System.out.println("Creating...");
        repo.create(kai);
        repo.create(tiffany);
        repo.create(kyle);
        repo.create(cody);
        repo.create(stefan);
        repo.create(shabana);

        Scanner sc = new Scanner(System.in);
        sc.nextLine();


        System.out.println("Updating...");
        kai.setLastName("Hutcherson");
        tiffany.setFirstName("Madam Tiffany");
        repo.update(kai);
        repo.update(tiffany);

        sc.nextLine();

        System.out.print("Associate with ID 4:  ");
        AssociateModel queryAssociate = repo.read(4);
        System.out.println("name: " + queryAssociate.getLastName()+ ", " + queryAssociate.getFirstName());

        sc.nextLine();

        System.out.println("Deleting...");

        repo.delete(2);
        repo.delete(5);

        sc.nextLine();
    }
}