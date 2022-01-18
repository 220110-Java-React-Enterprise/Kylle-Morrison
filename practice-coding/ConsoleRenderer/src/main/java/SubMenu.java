public class SubMenu extends View{
    public SubMenu() {

    }

    @Override
    public void renderView() {
        System.out.println("========== Sub Menu ==========");
        System.out.println("Welcome, " + DataStore.getName());
    }
}
