package mars.mips.SO.ProcessManager;

import mars.mips.hardware.RegisterFile;

public class PCB {
  public enum State {
    READY,
    RUNNING,
    BLOCKED,
  };

  private int pid;
  private int memoryAddress;
  private State state = State.READY;
  private static final int registersQty = RegisterFile.getRegisters().length;
  private int[] registers = new int[registersQty];

  public PCB(int pid, int memoryAddress) {
    this.pid = pid;
    this.memoryAddress = memoryAddress;
  }

  public int getPid() {
    return pid;
  }

  public void setPid(int pid) {
    this.pid = pid;
  }

  public int getMemoryAddress() {
    return this.memoryAddress;
  }

  public void setMemoryAddress(int memoryAddress) {
    this.memoryAddress = memoryAddress;
  }

  public int[] getRegisters() {
    return this.registers;
  }

  public State getState() {
    return this.state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public void copyRegistersFromFile() {
    for (int i = 0; i < registersQty; i++) {
      this.registers[i] = RegisterFile.getValue(i);
    }
  }

  public void copyRegistersToFile() {
    for (int i = 0; i < registersQty; i++) {
      RegisterFile.updateRegister(i, this.registers[i]);
    }
  }
}
