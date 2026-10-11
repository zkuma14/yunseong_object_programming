import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] history = new String[10];
        int historyCount = 0;
        String lastSnippet = "";

        while (true) {
            System.out.print("jshell> ");

            if (!scanner.hasNextLine()) {
                break;
            }

            String input = scanner.nextLine();

            // 입력 내역 저장
            history[historyCount] = input;
            historyCount++;

            // /exit
            if (input.equals("/exit")) {
                System.out.println("Goodbye.");
                break;
            }

            // /help
            else if (input.equals("/help")) {
                System.out.println(
                    "Type a Java language expression, statement, or declaration."
                );
                System.out.println();
                System.out.println("Or type one of the following commands:");
                System.out.println();
                System.out.println("/list: list the source you have typed.");
                System.out.println();
                System.out.println("/exit: exit the jshell tool");
                System.out.println();
                System.out.println("/history: history of what you have typed.");
                System.out.println();
                System.out.println("/ !: rerun last snippet.");
            }

            // /history
            else if (input.equals("/history")) {
                for (int i = 0; i < historyCount; i++) {
                    System.out.println(history[i]);
                }
            }

            // /list
            else if (input.equals("/list")) {
                int listIndex = 1;

                for (int i = 0; i < historyCount; i++) {
                    if (!history[i].startsWith("/")) {
                        System.out.println(
                            listIndex + " : " + history[i]
                        );
                        listIndex++;
                    }
                }
            }

            // /!
            else if (input.equals("/!") || input.equals("/ !")) {
                if (!lastSnippet.equals("")) {
                    System.out.println(
                        "Re-running '" + lastSnippet + "'."
                    );
                }
            }

            // 잘못된 명령어
            else if (input.startsWith("/")) {
                System.out.println("Invalid command: " + input);
                System.out.println();
                System.out.println("Type /help for help.");
            }

            // 일반 명령문
            else {
                lastSnippet = input;
                System.out.println("Running '" + input + "'.");
            }

            // 입력 10개가 쌓이면 명령 처리 완료 후 버퍼 초기화
            if (historyCount >= history.length) {
                System.out.println("The history buffer is cleared.");
                historyCount = 0;
            }
        }

        scanner.close();
    }
}
