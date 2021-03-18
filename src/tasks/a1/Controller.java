package tasks.a1;

import gradingTools.comp533s19.assignment0.AMapReduceTracer;

import java.util.Scanner;

public class Controller extends AMapReduceTracer{
    private Model Model;
    public Controller(Model Model){
        this.Model = Model;
    }
    void run(){

        this.traceNumbersPrompt();
        Scanner scanner = new Scanner(System.in);
        Model.setInputString(scanner.nextLine());

    }
    @Override
    public String toString(){
        return "CONTROLLER";
    }

}
