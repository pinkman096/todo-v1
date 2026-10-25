public class TodoItem {
    private int itemId;
    private String itemTitle;
    private boolean itemStatus;

    public TodoItem(int itemId, String itemTitle) {
        this.itemId = itemId;
        this.itemTitle = itemTitle;
        this.itemStatus = false;
    }

    public int getItemId() {
        return this.itemId;
    }

    public String getItemTitle() {
        return this.itemTitle;
    }

    public boolean isItemStatus() {
        return this.itemStatus;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public void setItemStatus(boolean itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Override
    public String toString() {
        String statusMarker = new String();

        if (itemStatus) {
            statusMarker = " [x]";
        } else {
            statusMarker = " [ ]";
        }


        return itemId + " - " + itemTitle + statusMarker;
    }
}