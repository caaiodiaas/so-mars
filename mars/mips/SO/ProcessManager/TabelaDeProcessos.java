package mars.mips.SO.ProcessManager;

import java.util.ArrayList;
import java.util.List;

import mars.mips.SO.ProcessManager.PCB.State;

public class TabelaDeProcessos {
    
    private static List<PCB> prontos = new ArrayList<PCB>();
    private static PCB execucao;


    public static void addReady (long address, State state){
        PCB process = new PCB(address);
        prontos.add(process);
        process.setPid(process.getPid()+ 1);
        process.setState(state);
        Escalonador.schedule(process);        
    }

    public static void addProcess(PCB process){
        prontos.add(process);
    }

    public static void removeProcess(){
        prontos.remove(0);
    }

    public static List<PCB> getProntos() {
        return prontos;
    }

    public static void setProntos(List<PCB> prontos) {
        TabelaDeProcessos.prontos = prontos;
    }

    public static PCB getExecucao() {
        return execucao;
    }

    public static void setExecucao(PCB execucao) {
        TabelaDeProcessos.execucao = execucao;
    }

}




