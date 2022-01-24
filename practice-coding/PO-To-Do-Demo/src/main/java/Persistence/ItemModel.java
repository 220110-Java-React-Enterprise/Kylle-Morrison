package Persistence;

public class ItemModel {
    private Integer itemID;
    private String message;
    private Boolean completed;
    private Integer userId; // FK pointing to the pk in UserModel

    public ItemModel() {
    }

    public ItemModel(Integer itemID, String message, Boolean completed, Integer userId) {
        this.itemID = itemID;
        this.message = message;
        this.completed = completed;
        this.userId = userId;
    }

    public ItemModel(String message, Boolean completed, Integer userId) {
        this.message = message;
        this.completed = completed;
        this.userId = userId;
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
