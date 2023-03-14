package assignment5;

public class Main {
    public static void main(String[] args) {
        for(int i=1;i<10;i++) {
            String fold_string=paperfold(i);
            System.out.println("For "+i+" folds we get: "+fold_string+"\n");
        }
    }

    public static String reverse(String str) {
        char arr[] = str.toCharArray();
        if(arr.length<=1) { //terminating condition for the recursive loop
            return str;
        }
        String rev = str.substring(1,arr.length);
        return reverse(rev) + arr[0];
    }

    public static String replace(String str) {
        char arr[] = str.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '^') { //replace all "^" with "v"
                arr[i] = 'v';
            }
            else if(arr[i] == 'v') { //replace all "v" with "^"
                arr[i] = '^';
            }
        }
        return new String(arr);
    }

    public static String paperfold(int folds) {
        if(folds <= 1) { //terminating condition for the recursive loop
            return "v";
        }
        return replace(reverse(paperfold(folds-1))) + "v" + paperfold(folds-1);
    }
}
