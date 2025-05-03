import com.auggpt.backend.controller.MainController;
import com.auggpt.backend.model.AgentType;

public class AutoTestGeneratorClient {
    public static void main(String[] args) {
        MainController controller = new MainController();
        controller.launch();
//        controller.plain();
        System.exit(0);
    }
}
