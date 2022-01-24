package Utils;

import Views.View;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ViewManager {
    private static ViewManager viewManager;
    private boolean running;
    private Scanner scanner = new Scanner(System.in);
    List<View> viewList;

    View nextView;

    private ViewManager() {
        //set up starting values and references
        running = true;
        scanner = new Scanner(System.in);
        viewList = new LinkedList<>();
    }

    public static ViewManager getViewManager() {
        if(viewManager == null) {
            viewManager = new ViewManager();
        }
        return viewManager;
    }

    public void navigate(String destination) {
        for(View view : viewList) {
            if(view.getViewName().equals(destination)) {
                nextView = view;
            }
        }
    }


}
