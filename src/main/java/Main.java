import controller.Controller;
import model.Model;
import view.ConsoleView;
import view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new ConsoleView();
        Controller controller = new Controller(model, view);
        controller.run();
    }
}
