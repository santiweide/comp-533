package comp533.a2;

import comp533.a2.controller.Controller;
import comp533.a2.model.IntSummingModel;
import comp533.a2.view.View;

public class IntSumming {
    public static void main(String[] args) {
        IntSummingModel intSummingModel = new IntSummingModel();
        Controller intSummingController = new Controller(intSummingModel);
        View view = new View(intSummingModel);
        intSummingController.run();
    }
}
