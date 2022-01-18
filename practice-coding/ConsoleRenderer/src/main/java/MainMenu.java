public class MainMenu extends View{

    public MainMenu() {
        viewName = "MainMenu";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("========== Main Menu ==========");
        System.out.println("Enter name: ");

        //
        String input = viewManager.getScanner().nextLine();

        //perform validation
        DataStore.setName(input);
        viewManager.navigate("Submenu");

    }
}
