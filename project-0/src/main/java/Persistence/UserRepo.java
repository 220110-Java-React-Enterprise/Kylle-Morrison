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
        String sql = "INSERT INTO users (email, password) VALUES (?, ?)";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, userModel.getEmail());
        pstmt.setString(2, userModel.getPassword());

        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
        rs.next();
        return rs.getInt(1);
    }

    @Override
    public UserModel read(Integer id) throws SQLException, IOException {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();

        UserModel user = new UserModel();
        if (rs.next()) {
            user.setUserID(rs.getInt("user_id"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        } else {
            return null;
        }
    }

    @Override
    public UserModel update(UserModel userModel) throws SQLException, IOException {
        String sql = "UPDATE users SET email = ?, password = ? WHERE user_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, userModel.getEmail());
        pstmt.setString(2, userModel.getPassword());
        pstmt.setInt(3, userModel.getUserID());

        pstmt.executeUpdate();

        String verify = "SELECT * FROM users WHERE user_id = ?";
        PreparedStatement vstmt = ConnectionManager.getConnection().prepareStatement(verify);
        vstmt.setInt(1, userModel.getUserID());
        ResultSet rs = vstmt.executeQuery();

        if(rs.next()) {
            UserModel verifiedUserModel = new UserModel();
            verifiedUserModel.setUserID(rs.getInt("user_id"));
            verifiedUserModel.setEmail(rs.getString("email"));
            verifiedUserModel.setPassword(rs.getString("password"));
            return verifiedUserModel;
        }

        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException, IOException {
        String sql = "DELETE FROM users WHERE user_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }

    public UserModel authenticate(String email, String password) throws SQLException, IOException {
        String sql = "SELECT * FROM users WHERE email = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next() && rs.getString("password").equals(password)) {
            return new UserModel(rs.getInt("user_id"), rs.getString("email"), rs.getString("password"));
        }
        return null;
    }
}
