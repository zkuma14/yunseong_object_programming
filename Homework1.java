import java.util.Scanner;

public class Homework1{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num ,sum= 0;
    for(int i = 0; i<5; i++){
      System.out.print("정수 입력: ");
      num = sc.nextInt();
      sum += num;
      System.out.printf("입력된 정수의 합은 %d\n" ,sum);
    }
  }
}
