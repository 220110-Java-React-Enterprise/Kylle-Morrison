package Views;

import Persistence.UserModel;
import Persistence.UserRepo;
import Utils.ContextStore;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterView extends View{
    public RegisterView() {
        viewName = "register";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() throws SQLException, IOException {
        System.out.println("\nRegister a New User\n====================");
        System.out.print("Enter your email: ");
        String email = viewManager.getScanner().nextLine();

        System.out.print("Enter a new password: ");
        String password = viewManager.getScanner().nextLine();

        UserModel newUser = new UserModel(email, password);
        UserRepo repo = new UserRepo();
        newUser.setUserID(repo.create(newUser));

        ContextStore.setCurrentUser(newUser);

        viewManager.navigate("accountList");
    }
}
