// 파일명: Homework5.java

class Monitor {
    private String size;
    private String color;
    private String powerConsumption;

    public Monitor(String size, String color, String powerConsumption) {
        this.size = size;
        this.color = color;
        this.powerConsumption = powerConsumption;
    }

    public void turnOn() {
        System.out.println("모니터 전원이 켜졌습니다.");
    }

    public void printInfo() {
        System.out.println("  - 크기: " + size);
        System.out.println("  - 색상: " + color);
        System.out.println("  - 전력소모: " + powerConsumption);
    }
}

class Computer {
    private String cpu;
    private String memory;
    private String hdd;
    private String color;
    private String powerSupply;

    public Computer(String cpu, String memory, String hdd, String color, String powerSupply) {
        this.cpu = cpu;
        this.memory = memory;
        this.hdd = hdd;
        this.color = color;
        this.powerSupply = powerSupply;
    }

    public void turnOn() {
        System.out.println("본체 전원이 켜졌습니다.");
    }

    public void printInfo() {
        System.out.println("  - CPU: " + cpu);
        System.out.println("  - 메모리: " + memory);
        System.out.println("  - HDD: " + hdd);
        System.out.println("  - 컬러: " + color);
        System.out.println("  - 파워: " + powerSupply);
    }
}

class PersonalComputer {
    private Computer computer;
    private Monitor monitor;

    public PersonalComputer(Computer computer, Monitor monitor) {
        this.computer = computer;
        this.monitor = monitor;
    }

    public void turnOn() {
        System.out.println("[전원 켜기]");
        computer.turnOn();
        monitor.turnOn();
    }

    public void printInfo() {
        System.out.println("\n[컴퓨터 정보]");
        computer.printInfo();
        System.out.println("\n[모니터 정보]");
        monitor.printInfo();
    }
}

public class Homework5 {
    public static void main(String[] args) {
        // 요구사항 지정 정보 생성 (모두 String 타입)
        Monitor monitor = new Monitor("24인치", "검은색", "45W");
        Computer computer = new Computer("Core i7", "16GB", "2TB", "흰색", "500W");

        // PersonalComputer 객체 생성 및 메소드 호출
        PersonalComputer pc = new PersonalComputer(computer, monitor);

        pc.turnOn();
        pc.printInfo();
    }
}
