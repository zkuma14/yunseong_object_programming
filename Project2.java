class CPUComponent {
    protected String name;

    public CPUComponent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "] 가동 준비 완료.";
    }
}

class Register extends CPUComponent {
    private int value;

    public Register(String name) {
        super(name);
        this.value = 0;
    }

    public void write(int data) {
        this.value = data;
    }

    public int read() {
        return this.value;
    }

    @Override
    public String toString() {
        return name + "=" + value;
    }
}

class ControlUnit extends CPUComponent {
    public ControlUnit() {
        super("Control Unit");
    }

    public String[] fetch_and_decode(String instruction) {
        String[] tokens = instruction.trim().split("\\s+");

        String decoded = "";
        for (int i = 0; i < tokens.length; i++) {
            decoded += tokens[i];
            if (i < tokens.length - 1) {
                decoded += " ";
            }
        }
        System.out.println("[" + name + "] 명령어 해독: " + decoded);

        return tokens;
    }
}

class ALU extends CPUComponent {
    public ALU() {
        super("ALU");
    }

    public int execute(String op, int val1, int val2) {
        if ("ADD".equals(op)) {
            System.out.println("[" + name + "] 연산 수행: " + val1 + " + " + val2);
            return val1 + val2;
        } else if ("SUB".equals(op)) {
            System.out.println("[" + name + "] 연산 수행: " + val1 + " - " + val2);
            return val1 - val2;
        }
        return 0;
    }
}

class CPU {
    private ControlUnit cu;
    private ALU alu;
    private Register r1;
    private Register r2;

    public CPU() {
        this.cu = new ControlUnit();
        this.alu = new ALU();
        this.r1 = new Register("R1");
        this.r2 = new Register("R2");
    }

    public void runProgram(String[] program) {
        for (int i = 0; i < program.length; i++) {
            System.out.println();
            String[] tokens = cu.fetch_and_decode(program[i]);

            if (tokens.length < 3) {
                continue;
            }

            String op = tokens[0];

            if ("MOV".equals(op)) {
                Register target = getRegister(tokens[1]);
                int data = Integer.parseInt(tokens[2]);
                if (target != null) {
                    target.write(data);
                }
            } else if ("ADD".equals(op) || "SUB".equals(op)) {
                Register reg1 = getRegister(tokens[1]);
                Register reg2 = getRegister(tokens[2]);
                if (reg1 != null && reg2 != null) {
                    int result = alu.execute(op, reg1.read(), reg2.read());
                    reg1.write(result);
                }
            }

            System.out.println("[현재 레지스터 상태] " + r1 + " | " + r2);
        }
        System.out.println();
    }

    private Register getRegister(String regName) {
        if ("R1".equals(regName)) {
            return r1;
        } else if ("R2".equals(regName)) {
            return r2;
        }
        return null;
    }
}

public class Project2 {
    public static void main(String[] args) {
        System.out.println("=== CPU 가상 프로그램 가동 ===");

        CPU myCpu = new CPU();

        System.out.println(new CPUComponent("Control Unit"));
        System.out.println(new CPUComponent("ALU"));
        System.out.println(new Register("R1"));
        System.out.println(new Register("R2"));

        String[] program = {
                "MOV  R1 25",
                "MOV  R2 10",
                "ADD  R1 R2",
                "SUB  R1 R2"
        };

        myCpu.runProgram(program);
        System.out.println("=== 프로그램 가동 종료 ===");
    }
}
