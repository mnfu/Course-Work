package lab7;

public class Calculator implements CalcOp{
    public float add(float n1, float n2) {
        return n1+n2;
    }
    public float subtract(float n1, float n2) {
        return n1-n2;
    }
    public float multiply(float n1, float n2) {
        return n1*n2;
    }
    public float divide(float n1, float n2) {
        return n1/n2;
    }
}
