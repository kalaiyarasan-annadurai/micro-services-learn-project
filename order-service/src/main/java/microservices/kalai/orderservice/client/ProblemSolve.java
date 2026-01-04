public class ProblemSolve {
    public static void main(String[] args) {
        // input - [7,1,5,3,6,4]

        int input[] = {7,1,5,3,6,4};

       int result =  getProfit(input);

       System.out.print("the result -> "+result);
    }
    static int  getProfit (int[] input){
        int buy = input[0];
    int profit = 0;


    for(int i = 1;i< input.length;i++){
          int todayVal = input[i];
          int todayProfit = todayVal - buy;
          if(todayProfit > profit){
            profit = todayProfit;
          }

          if(buy > todayVal)
               buy = todayVal;
    }

    return profit;
    }
}
