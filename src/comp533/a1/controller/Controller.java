package comp533.a1.controller;

import comp533.a1.model.IModel;
import comp533.a1.model.TokenCountingModel;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;

import java.util.Scanner;

public class Controller extends AMapReduceTracer{
    private IModel model;
    public Controller(IModel model){
        this.model = model;
    }
    public void run(){
        this.traceNumbersPrompt();
        Scanner scanner = new Scanner(System.in);
        model.setInputString(scanner.nextLine());
    }
    @Override
    public String toString(){
        return "Controller";
    }

}
