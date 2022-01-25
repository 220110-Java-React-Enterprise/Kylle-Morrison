package Persistence;

import java.io.IOException;
import java.sql.SQLException;

public class AccountRepo implements DataSourceCRUD<AccountModel> {
    @Override
    public Integer create(AccountModel accountModel) throws SQLException, IOException {
        return null;
    }

    @Override
    public AccountModel read(Integer id) throws SQLException, IOException {
        return null;
    }

    @Override
    public AccountModel update(AccountModel accountModel) throws SQLException, IOException {
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException, IOException {

    }
}
