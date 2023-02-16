package lab6;

public class FibIteration implements FindFib{

    @Override
    public int calculate_fib(int num) {
        if(num == 1 || num == 2){
            return 1;
        }
        else {
            int previous = 0;
            int current = 1;
            for(int i = 0; i < num; i++) {
                int tempprev = current;
                current = previous + current;
                previous = tempprev;
            }
            if(previous == Integer.MAX_VALUE || previous < 0){
                return Integer.MAX_VALUE;
            }
            return previous;
        }
    }
}
