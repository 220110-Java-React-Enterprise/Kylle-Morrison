package Views;

import Utils.ViewManager;

import java.io.IOException;
import java.sql.SQLException;

public class AccountListView extends View{
    public AccountListView() {
        viewName = "accountList";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() throws SQLException, IOException {

    }
}
