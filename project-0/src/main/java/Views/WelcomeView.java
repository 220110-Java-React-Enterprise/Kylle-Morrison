package Views;

import Utils.ViewManager;

public class WelcomeView extends View{
    public WelcomeView() {
        viewName = "welcome";
        viewManager = ViewManager.getViewManager();
    }

    @Override
    public void renderView() {
        System.out.println("Welcome to Kai's Bank App!\n" +
                "====================\n" +
                "1) Register\n" +
                "2) Login\n" +
                "====================");

        String input = viewManager.getScanner().nextLine();

        switch(input) {
            case "1":
                viewManager.navigate("register");
                break;
            case "2":
                viewManager.navigate("login");
                break;
            default:
                System.out.println("Enter either 1 or 2...\n\n");
                break;
        }
    }
}
