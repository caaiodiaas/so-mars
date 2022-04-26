package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.SO.ProcessManager.TabelaDeProcessos;
import mars.mips.SO.ProcessManager.PCB.State;
import mars.mips.hardware.RegisterFile;

public class SyscallFork extends AbstractSyscall{

    public SyscallFork() {
        super(20, "SyscallFork");
    }

    @Override
    public void simulate(ProgramStatement statement) throws ProcessingException { 
        try {
            TabelaDeProcessos.addReady(RegisterFile.getValue(4), State.READY);
        } catch (Exception e) {
        }
    }
    
}
