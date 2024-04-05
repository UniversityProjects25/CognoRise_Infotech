import java.util.*;

public class Task_3_Calculator_app {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Number: ");
        int f =sc.nextInt();
        System.out.println("Enter Second Number: ");
        int s =sc.nextInt();
        System.out.println("Enter the operator(+ , - , / , *): ");
        char operator= sc.next().charAt(0);
        try{
            double result;
            switch (operator){
                case '+':
                    result = f+s;
                    System.out.println("Result: " + result);
                    break;
                case '-':
                    result = f-s;
                    System.out.println("Result: " + result);
                    break;
                case '*':
                    result = f*s;
                    System.out.println("Result: " + result);
                    break;
                case '/':
                    if(s==0){
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = f/s;
                    System.out.println("result: " + result);
                    break;
            }
        }
        catch(Exception e ){
            System.out.println("An error occured: " + e.getMessage());
        }
        finally{
            sc.close();
        }
    }

}
