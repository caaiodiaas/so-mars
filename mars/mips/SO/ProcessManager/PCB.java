package mars.mips.SO.ProcessManager;

import java.util.Date;

import mars.mips.hardware.RegisterFile;

public class PCB {
  public enum State {
    READY,
    RUNNING,
    BLOCKED,
  };

  private long pid;
  private long initialAddress;
  private State state = State.READY;
  private static final int registersQty = 34;
  private int[] registers = new int[registersQty];

  public PCB(long memoryAddress) {
    this.setPid(new Date().getTime());
    this.setInitialAddress(memoryAddress);
  }

  public long getPid() {
    return this.pid;
  }

  public void setPid(long pid) {
    this.pid = pid;
  }

  public long getInitialAddress() {
    return this.initialAddress;
  }

  public void setInitialAddress(long initialAddress) {
    this.initialAddress = initialAddress;
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
    for (int i = 0; i < registersQty - 2; i++) {
      this.registers[i] = RegisterFile.getValue(i);
    }
    for (int i = registersQty; i < registersQty + 2; i++) {
      this.registers[i] = RegisterFile.getValue(i + 1);
    }
  }

  public void copyRegistersToFile() {
    for (int i = 0; i < registersQty - 2; i++) {
      RegisterFile.updateRegister(i, this.registers[i]);
    }
    for (int i = registersQty; i < registersQty + 2; i++) {
      RegisterFile.updateRegister(i + 1, this.registers[i]);
    }
  }
}
