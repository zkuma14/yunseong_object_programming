import java.util.Scanner;

public class Homework4 {

    // 1. 재귀 호출(Recursion)을 이용한 최대공약수 함수
    public static int gcd(int m, int n) {
        // 조건 2: n이 0이면 m을 반환하고 종료
        if (n == 0) {
            return m;
        }
        
        // 조건 3: 첫 번째 인자 = 작은 수, 두 번째 인자 = (큰 수 % 작은 수)
        int min = Math.min(m, n);
        int max = Math.max(m, n);
        
        return gcd(min, max % min);
    }

    // 2. 반복문(Loop)을 이용한 최대공약수 함수
    public static int gcdIterative(int m, int n) {
        while (n != 0) {
            int min = Math.min(m, n);
            int max = Math.max(m, n);
            
            m = min;
            n = max % min;
        }
        return m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("두 수를 입력하세요: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        // 재귀 함수 호출
        int result = gcd(num1, num2);

        System.out.println("두 수의 최대공약수는 " + result + "입니다");

        scanner.close();
    }
}
