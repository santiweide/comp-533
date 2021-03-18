package comp533.a1;

import comp533.a1.controller.TokenCountingController;
import comp533.a1.model.TokenCountingModel;
import comp533.a1.view.View;

public class IntSumming {
    public static void main(String[] args) {
        TokenCountingModel TokenCountingModel = new TokenCountingModel();
        TokenCountingController tokenCountingController = new TokenCountingController(TokenCountingModel);
        View view = new View(TokenCountingModel);
        tokenCountingController.run();
    }
}
