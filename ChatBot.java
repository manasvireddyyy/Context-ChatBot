import java.util.Scanner;
import java.util.HashMap;

public class ChatBot{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> responses = new HashMap<>();
        responses.put("hi", "hello!!");
        responses.put("how are you?", "I'm a bot, but thanks for asking!!");
        responses.put("what is your name?", "I'm a dumb bot ( coz there is no intelligence in me!!) ");
        responses.put("what is your purpose?","to clarify your queries");
        responses.put("good morning"," good morning sunshinee!!");
        responses.put("good night","good night moon");
        responses.put("who made you","charming MANASVI");
        responses.put("what can you do","I can small talk!");
        while(true){
            System.out.println("You: ");
            String user  = sc.nextLine().trim().toLowerCase();
            System.out.println("DEBUG: ["+user+"]");

            if(user.equals("bye")){
                System.out.println("dumbo: GoooodBoiiieee!!");
                break;
            }
            if(responses.containsKey(user)){
                System.out.println("dumbo: "+responses.get(user));
            }
            else{
                System.out.println("dumbo: Soooriieee!!, I dont get you");
            }
            
        }
        sc.close();
    }
}