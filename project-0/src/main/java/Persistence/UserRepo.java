package Persistence;

import Utils.ConnectionManager;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepo implements DataSourceCRUD<UserModel> {

    @Override
    public Integer create(UserModel userModel) throws SQLException, IOException {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, userModel.getUsername());
        pstmt.setString(2, userModel.getPassword());

        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public UserModel read(Integer id) throws SQLException, IOException {
        return null;
    }

    @Override
    public UserModel update(UserModel userModel) throws SQLException, IOException {
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException, IOException {

    }
}
