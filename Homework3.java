import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받을 정수의 개수
        int n = sc.nextInt();

        // 배열 생성
        int[] numbers = new int[n];

        // 정수 입력
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        // 최소값과 최대값을 배열의 첫 번째 요소로 초기화
        int min = numbers[0];
        int max = numbers[0];

        // 배열을 탐색하면서 최소값과 최대값 갱신
        for (int i = 1; i < n; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }

            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        // 결과 출력
        System.out.println("최소값: " + min);
        System.out.println("최대값: " + max);

        sc.close();
    }
}
