package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.SO.ProcessManager.Escalonador;
import mars.mips.SO.ProcessManager.PCB;
import mars.mips.hardware.RegisterFile;


public class SyscallProcessTerminate extends AbstractSyscall{

    public SyscallProcessTerminate(int number, String end) {
        super(22, "SyscallProcessTerminate");
    }

    @Override
    public void simulate(ProgramStatement statement) throws ProcessingException { 
        PCB process = new PCB(RegisterFile.getValue(2));
        Escalonador.schedule(process);
    }
    
}
