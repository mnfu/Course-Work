public class lab1 {
    public static void main(String[] args) {
        char[][] car;
        car = make_forward();
        print_char(car);
        print_char(make_mirror(car));
        print_char(car, make_mirror(car));
    }
    public static char[][] make_mirror(char[][] car) {
        char[][] mirror = new char[4][13];
        for (int i = 0; i < car.length; i++) {
            for (int j = 0; j < car[0].length; j++) {
                if(car[i][car[0].length - 1 - j] == '(') {
                    mirror[i][j] = ')';
                }
                else if(car[i][car[0].length - 1 - j] == ')') {
                    mirror[i][j] = '(';
                }
                else if(car[i][car[0].length - 1 - j] == '/') {
                    mirror[i][j] = '\\';
                }
                else if(car[i][car[0].length - 1 - j] == '\\') {
                    mirror[i][j] = '/';
                }
                else {
                    mirror[i][j] = car[i][car[0].length - 1 - j];
                }
            }
        }
        return mirror;
    }
    public static void print_char(char[][] car) {
        for (int i = 0; i < car.length; i++) {
            for (int j = 0; j < car[0].length; j++) {
                System.out.print(car[i][j]);
            }
            System.out.println();
        }
    }
    public static void print_char(char[][] car, char[][] car2) {
        for (int i = 0; i < car.length; i++) {
            for (int j = 0; j < car[0].length*2; j++) {
                if(j < 13) {
                    System.out.print(car[i][j]);
                }
                else {
                    System.out.print(car2[i][j-13]);
                }
            }
            System.out.println();
        }
    }
    public static char[][] make_forward() {
        char[][] pixel = new char[4][13];
        pixel[0][0]=' ';
        pixel[0][1]=' ';
        pixel[0][2]='_';
        pixel[0][3]='_';
        pixel[0][4]='_';
        pixel[0][5]='_';
        pixel[0][6]='_';
        pixel[0][7]='_';
        pixel[0][8]=' ';
        pixel[0][9]=' ';
        pixel[0][10]=' ';
        pixel[0][11]=' ';
        pixel[0][12]=' ';
        pixel[1][0]=' ';
        pixel[1][1]='/';
        pixel[1][2]='|';
        pixel[1][3]='_';
        pixel[1][4]='|';
        pixel[1][5]='|';
        pixel[1][6]='_';
        pixel[1][7]='\\';
        pixel[1][8]='\'';
        pixel[1][9]='.';
        pixel[1][10]='_';
        pixel[1][11]='_';
        pixel[1][12]=' ';
        pixel[2][0]='(';
        pixel[2][1]=' ';
        pixel[2][2]=' ';
        pixel[2][3]=' ';
        pixel[2][4]='_';
        pixel[2][5]=' ';
        pixel[2][6]=' ';
        pixel[2][7]=' ';
        pixel[2][8]=' ';
        pixel[2][9]='_';
        pixel[2][10]=' ';
        pixel[2][11]='_';
        pixel[2][12]='\\';
        pixel[3][0]='=';
        pixel[3][1]='\'';
        pixel[3][2]='-';
        pixel[3][3]='(';
        pixel[3][4]='_';
        pixel[3][5]=')';
        pixel[3][6]='-';
        pixel[3][7]='-';
        pixel[3][8]='(';
        pixel[3][9]='_';
        pixel[3][10]=')';
        pixel[3][11]='-';
        pixel[3][12]='\'';
        return pixel;
    }
}
