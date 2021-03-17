package tasks.a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TokenCounter {
    public static void main(String[] args) {
        System.out.println("Please enter quit or a line of tokens to be processed separated by spaces");
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        Map<String, Integer> strMap = new HashMap<>(inputs.length);
        for(String input:inputs){
            strMap.put(input, strMap.get(input)==null?1:strMap.get(input)+1);
        }
        boolean first = true;
        for(String key:strMap.keySet()){
            if(!first){
                System.out.print(",");
            } else {
                first = false;
            }
            System.out.print(key + "=" + strMap.get(key));
        }

    }
}
