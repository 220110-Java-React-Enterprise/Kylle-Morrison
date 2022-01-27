import Utils.ConnectionManager;
import Utils.ViewManager;
import Views.*;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String ...args) {

        ViewManager.getViewManager().registerView(new WelcomeView());
        ViewManager.getViewManager().registerView(new RegisterView());
//        ViewManager.getViewManager().registerView(new LoginView());

//        Scanner sc = new Scanner(System.in);
//        int i = sc.nextInt();
//        sc.nextLine();



        try {
            Connection conn = ConnectionManager.getConnection();

            ViewManager.getViewManager().navigate("welcome");
            while(ViewManager.getViewManager().isRunning()) {
                ViewManager.getViewManager().render();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}