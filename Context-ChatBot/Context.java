import java.util.Scanner;
import java.util.ArrayList;


public class Context {
    public  static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> history = new ArrayList<>();

        
        while(true){
        
            System.out.print("You:");
            String prompt  = sc.nextLine();

            if(prompt.equalsIgnoreCase("bye")){
                break;
            }
            history.add("user:"+prompt);
            String aireply = "I'm stilllearning";
            history.add("Ai:"+aireply);
            System.out.println("GoldFish:"+aireply);
        System.out.println(history);
        }

        sc.close();
        
        
    
    }
}