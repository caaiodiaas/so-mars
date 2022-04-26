package mars.mips.SO.ProcessManager;

import mars.mips.SO.ProcessManager.PCB.State;

public class Escalonador {

    public static void schedule(PCB process){
        if(TabelaDeProcessos.getProntos().size() > 0 && process.getState() == State.READY){
            TabelaDeProcessos.getExecucao().setState(State.READY);
            TabelaDeProcessos.addProcess(TabelaDeProcessos.getExecucao());
            TabelaDeProcessos.getProntos().get(0).setState(State.RUNNING);
            TabelaDeProcessos.removeProcess();
        }else{
            TabelaDeProcessos.addProcess(process);
        }
    }
}
