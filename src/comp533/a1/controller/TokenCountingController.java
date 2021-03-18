package comp533.a1.controller;

import comp533.a1.model.TokenCountingModel;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;

import java.util.Scanner;

public class TokenCountingController extends AMapReduceTracer{
    private TokenCountingModel TokenCountingModel;
    public TokenCountingController(TokenCountingModel TokenCountingModel){
        this.TokenCountingModel = TokenCountingModel;
    }
    public void run(){
        this.traceNumbersPrompt();
        Scanner scanner = new Scanner(System.in);
        TokenCountingModel.setInputString(scanner.nextLine());
    }
    @Override
    public String toString(){
        return "Controller";
    }

}
