package mars.mips.SO.ProcessManager;

import mars.mips.hardware.Memory;
import mars.mips.hardware.Register;

public class PCB {

    private static enum Estado {pronto,executando,bloqueado};

    public static final int GLOBAL_POINTER_REGISTER = 28;
    public static final int STACK_POINTER_REGISTER = 29;
    
    private static Register [] regFile = 
    { new Register("$zero", 0, 0), new Register("$at", 1, 0),
       new Register("$v0", 2, 0),new Register("$v1", 3, 0),
       new Register("$a0", 4, 0),new Register("$a1", 5, 0),
       new Register("$a2", 6, 0),new Register("$a3", 7, 0),
       new Register("$t0", 8, 0),new Register("$t1", 9, 0),
       new Register("$t2", 10, 0),new Register("$t3", 11, 0), 
       new Register("$t4", 12, 0),new Register("$t5", 13, 0),
       new Register("$t6", 14, 0),new Register("$t7", 15, 0),
       new Register("$s0", 16, 0),new Register("$s1", 17, 0),
       new Register("$s2", 18, 0),new Register("$s3", 19, 0),
       new Register("$s4", 20, 0),new Register("$s5", 21, 0),
       new Register("$s6", 22, 0),new Register("$s7", 23, 0),
       new Register("$t8", 24, 0),new Register("$t9", 25, 0),
       new Register("$k0", 26, 0),new Register("$k1", 27, 0),
       new Register("$gp", GLOBAL_POINTER_REGISTER, Memory.globalPointer),
       new Register("$sp", STACK_POINTER_REGISTER, Memory.stackPointer),
       new Register("$fp", 30, 0),new Register("$ra", 31, 0)
     };

    public static int getGlobalPointerRegister() {
        return GLOBAL_POINTER_REGISTER;
    }

    public static int getStackPointerRegister() {
        return STACK_POINTER_REGISTER;
    }

    public static Register[] getRegFile() {
        return regFile;
    }

    public static void setRegFile(Register[] regFile) {
        PCB.regFile = regFile;
    }

    public static void copycontent(int reg){
        for(int i = 0; i < regFile.length; i++){
            regFile[i].setValue(reg);
        }
    }
}
