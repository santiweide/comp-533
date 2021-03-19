package comp533.a2.controller;

import comp533.a2.model.IModel;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;

import java.util.Scanner;

public class Controller extends AMapReduceTracer{
    private IModel model;
    public Controller(IModel model){
        this.model = model;
    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            this.traceNumbersPrompt();
            model.setInputString(scanner.nextLine());
        }
    }
    @Override
    public String toString(){
        return "Controller";
    }

}
