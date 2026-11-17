// 추상 클래스 Printer 설계
abstract class Printer {
    protected String model;          // 모델명
    protected int printedCount;      // 현재까지의 출력 매수
    protected int availableCount;    // 출력 가능 매수

    public Printer(String model, int availableCount) {
        this.model = model;
        this.availableCount = availableCount;
        this.printedCount = 0;       // 초기 출력 매수는 0으로 초기화
    }

    // 추상 멤버 함수
    public abstract boolean print();
}

// Printer를 상속받는 InkjetPrinter 클래스
class InkjetPrinter extends Printer {
    public InkjetPrinter(String model, int availableCount) {
        super(model, availableCount);
    }

    @Override
    public boolean print() {
        if (availableCount == 0) {
            System.out.println(model + ": " + (printedCount + 1) + "매째 인쇄 실패 - 잉크 부족.");
            return false;
        } else {
            printedCount++;
            availableCount--;
            return true;
        }
    }
}

// Printer를 상속받는 LaserPrinter 클래스
class LaserPrinter extends Printer {
    public LaserPrinter(String model, int availableCount) {
        super(model, availableCount);
    }

    @Override
    public boolean print() {
        if (availableCount == 0) {
            System.out.println(model + ": " + (printedCount + 1) + "매째 인쇄 실패 - 토너 부족.");
            return false;
        } else {
            printedCount++;
            availableCount--;
            return true;
        }
    }
}

// 실행 클래스
public class Homework7 {
    public static void main(String[] args) {
        InkjetPrinter inkjet = new InkjetPrinter("Brother DCP-T730DW", 7500);
        LaserPrinter laser = new LaserPrinter("Canon MFC643Cdw", 1500);
        
        while (inkjet.print());
        while (laser.print());
    }
}
