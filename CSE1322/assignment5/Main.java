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
        if(arr.length<=1) {
            return str;
        }
        String rev = str.substring(1,arr.length);
        return reverse(rev) + arr[0];
    }

    public static String replace(String str) {
        char arr[] = str.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '^') {
                arr[i] = 'v';
            }
            else if(arr[i] == 'v') {
                arr[i] = '^';
            }
        }
        return new String(arr);
    }

    public static String paperfold(int folds) {
        if(folds <= 1) {
            return "v";
        }
        return replace(reverse(paperfold(folds-1))) + "v" + paperfold(folds-1);
    }
}
