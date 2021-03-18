package tasks.a1;

import gradingTools.comp533s19.assignment0.AMapReduceTracer;

import java.util.Scanner;

public class Controller extends AMapReduceTracer{
    private Model model;
    public Controller(Model model){
        this.model = model;
    }
    void run(){

        this.traceNumbersPrompt();
        Scanner scanner = new Scanner(System.in);
        model.setInputString(scanner.nextLine());

    }
    @Override
    public String toString(){
        return "CONTROLLER";
    }

}
