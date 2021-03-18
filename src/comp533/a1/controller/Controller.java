package comp533.a1.controller;

import comp533.a1.model.Model;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;

import java.util.Scanner;

public class Controller extends AMapReduceTracer{
    private Model Model;
    public Controller(comp533.a1.model.Model Model){
        this.Model = Model;
    }
    public void run(){
        this.traceNumbersPrompt();
        Scanner scanner = new Scanner(System.in);
        Model.setInputString(scanner.nextLine());
    }
    @Override
    public String toString(){
        return "Controller";
    }

}
