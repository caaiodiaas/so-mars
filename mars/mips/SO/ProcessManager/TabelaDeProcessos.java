package mars.mips.SO.ProcessManager;

import java.util.List;

public class TabelaDeProcessos {
    
    private static List<PCB> prontos;
    private static PCB execucao;

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




