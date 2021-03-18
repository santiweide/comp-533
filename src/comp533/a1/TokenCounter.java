package comp533.a1;

import comp533.a1.model.Model;

public class TokenCounter {
    public static void main(String[] args) {
        Model Model = new Model();
        Controller controller = new Controller(Model);
        View view = new View(Model);
        controller.run();

//        System.out.println("Please enter quit or a line of tokens to be processed separated by spaces");
//        Scanner scanner = new Scanner(System.in);
//        String[] inputs = scanner.nextLine().split(" ");
//        Map<String, Integer> strMap = new HashMap<>(inputs.length);
//        for(String input:inputs){ATokenCountingMapper
//            strMap.put(input, strMap.get(input)==null?1:strMap.get(input)+1);
//        }
//        boolean first = true;
//        for(String key:strMap.keySet()){
//            if(!first){
//                System.out.print(",");
//            } else {
//                first = false;
//            }
//            System.out.print(key + "=" + strMap.get(key));
//        }

    }
}
