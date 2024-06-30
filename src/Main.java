public class Main {
    public static void main(String[] args) {

        double result = sum(99.0, 1.0);
        System.out.println(result);

        double result1 = minus (44, 45);
        System.out.println(result1);

        double result2 = del(76,2);
        System.out.println(result2);

        double result3 = mno(43,43);
        System.out.println(result3);

    }
    public static double sum( double x, double y){
        double result = x + y;
        return result;
    }

    public static double minus (double x, double y){
        double result = x-y;
        return result;
    }
    public static double del (double x, double y){
        double result = x/y;
        return result;
    }
    public static double mno(double x, double y){
        double result = x*y;
        return result;
    }
}