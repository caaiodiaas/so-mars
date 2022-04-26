package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.SO.ProcessManager.Escalonador;
import mars.mips.SO.ProcessManager.PCB;
import mars.mips.SO.ProcessManager.TabelaDeProcessos;
import mars.mips.SO.ProcessManager.PCB.State;
import mars.mips.hardware.RegisterFile;

public class SyscallProcessChange extends AbstractSyscall{

    public SyscallProcessChange() {
        super(21, "SyscallProcessChange");
    }

    @Override
    public void simulate(ProgramStatement statement) throws ProcessingException { 
        PCB process = new PCB(RegisterFile.getValue(2));
        TabelaDeProcessos.getExecucao().setState(State.READY);
        Escalonador.schedule(process);

    }
    
}
