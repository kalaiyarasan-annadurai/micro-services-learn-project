import java.util.HashMap;

// NOTE it is not part of the project - for company interview written
public class TestProgramming {
    // input  -> faaaabbccddddaa
    // output -> 4a2b2c4d2a

    static String getRestult(String input){

      char prev = input.charAt(0);
      int count = 1;
      StringBuilder sb  = new StringBuilder();

     for(int i = 1; i< input.length();i++){
         char currChar =   input.charAt(i);
         if(currChar != prev ){
            sb.append(count);
            sb.append(prev);

            count = 1;
         }
         count++;

         prev = currChar;
         
     }

    //  for(int i = 0;i< hashMap.size();i++){
    //     sb.append(hashMap.entrySet().next().getValue());
    //     sb.append(hashMap.entrySet().next().getKey());
    //  }

     return sb.toString();
    }
    public static void main(String[] args) {
        var result = getRestult("aaaabbccddddaa");
        System.out.printl("result - > "+result);
    }
}
