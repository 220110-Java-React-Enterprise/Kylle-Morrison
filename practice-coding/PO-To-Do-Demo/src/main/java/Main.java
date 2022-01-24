import Persistence.ItemModel;
import Persistence.ItemRepo;
import Persistence.UserModel;
import Persistence.UserRepo;
import Utils.ConnectionManager;
import Utils.ViewManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String ...args) throws SQLException, IOException {

        try {
            Connection conn = ConnectionManager.getConnection();

            ViewManager.getViewManager().navigate("welcome");
            while(ViewManager.getViewManager().isRunning()) {
                ViewManager.
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
