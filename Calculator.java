import java.util.Scanner;

public class Calculator{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        double num1,num2;
        char operator;
        double result=0;

        System.out.println("SimpleCalculator");
        System.out.print("Enter First Number:");
        num1=sc.nextDouble();

        System.out.print("Enter an operator(+,-,*,/):");
        operator=sc.next().charAt(0);

        System.out.print("Enter Second Number:");
        num2=sc.nextDouble();

        switch(operator){
            case '+':
               result=num1+num2;
               break;
            case '-':
               result=num1-num2;
               break;
            case '*':
               result=num1*num2;
               break;
            case '/':
               if(num2!=0){
                result=num1/num2;
               }
               else{
                System.out.println("error:division by Zero is not allowed.");
                return;
               }
               break;

            default:
               System.out.println("Invalid operator");
               return;

        }

        System.out.println("Result:"+result);

    }
}