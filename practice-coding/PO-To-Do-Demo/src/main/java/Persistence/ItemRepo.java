package Persistence;

import Utils.ConnectionManager;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemRepo implements DataSourceCRUD<ItemModel>{
    @Override
    public Integer create(ItemModel itemModel) throws SQLException, IOException {
        String sql = "INSERT INTO items (message, completed, user_id) VALUES (?, ?, ?)";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, itemModel.getMessage());
        pstmt.setBoolean(2, itemModel.getCompleted());
        pstmt.setInt(3, itemModel.getUserId());

        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();
        if(rs.next()) {
            return rs.getInt(1);
        }

        return -1;
    }

    @Override
    public ItemModel read(Integer id) throws SQLException, IOException {
        String sql = "SELECT * FROM items WHERE item_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();
        if(rs.next()) {
            ItemModel item = new ItemModel();
            item.setItemID(rs.getInt("item_id"));
            item.setMessage(rs.getString("message"));
            item.setCompleted(rs.getBoolean("completed"));
            item.setUserId(rs.getInt("user_id"));
            return item;
        }

        return null;
    }

    @Override
    public ItemModel update(ItemModel itemModel) throws SQLException, IOException {
        String sql = "UPDATE items SET message = ?, completed = ? WHERE item_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setString(1, itemModel.getMessage());
        pstmt.setBoolean(2, itemModel.getCompleted());
        pstmt.setInt(3, itemModel.getItemID());
        pstmt.executeUpdate();

        return itemModel;
    }

    @Override
    public void delete(Integer id) throws SQLException, IOException {
        String sql = "DELETE FROM items WHERE item_id = ?";
        PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}
