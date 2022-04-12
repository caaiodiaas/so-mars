package mars.mips.instructions.syscalls;

import mars.ProcessingException;
import mars.ProgramStatement;

public class SyscallFork extends AbstractSyscall{

    public SyscallFork(int number, String name) {
        super(number, name);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void simulate(ProgramStatement statement) throws ProcessingException {
        // TODO Auto-generated method stub
        
    }
    
}
