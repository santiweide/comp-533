package comp533.a2;

import comp533.a2.controller.Controller;
import comp533.a2.model.TokenCountingModel;
import comp533.a2.view.View;

public class TokenCounter {
    public static void main(String[] args) {
        TokenCountingModel TokenCountingModel = new TokenCountingModel();
        Controller controller = new Controller(TokenCountingModel);
        View view = new View(TokenCountingModel);
        controller.run();
    }
}
