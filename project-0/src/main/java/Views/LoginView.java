package Views;

import Persistence.UserModel;
import Persistence.UserRepo;
import Utils.ContextStore;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

public class LoginView extends View {
    public LoginView() {
        viewName = "login";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() throws SQLException, IOException {
        System.out.println("\nLogin\n====================");
        System.out.print("Enter email: ");
        String email = viewManager.getScanner().nextLine();

        System.out.print("Enter password: ");
        String password = viewManager.getScanner().nextLine();

        UserRepo repo = new UserRepo();
        UserModel user = repo.authenticate(email, password);

        if (user == null) {
            System.out.println("\nIncorrect credentials...\n\n");
            viewManager.navigate("welcome");
            return;
        }

        ContextStore.setCurrentUser(user);
        viewManager.navigate("accountList");
    }
}
