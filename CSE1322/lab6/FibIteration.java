package lab6;

public class FibIteration implements FindFib{

    @Override
    public int calculate_fib(int num) {
        if(num == 1 || num == 2){
            return 1;
        }
        else {
            int previous = 0; //tracks previous fib num
            int current = 1; //tracks current fib num
            for(int i = 0; i < num; i++) {
                int tempprev = current; //creates a save of the current num
                current = previous + current; //current is changed
                previous = tempprev; //previous num is set to the old current num
            }
            if(previous == Integer.MAX_VALUE || previous < 0){ //Make sure that the integer doesn't do wacky stuff past 32b lim
                return Integer.MAX_VALUE;
            }
            return previous;
        }
    }
}
