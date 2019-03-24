package machinelearning;

import java.util.List;

public interface Source {
  public List<Double> read();

  public int write(Double accuracy);
}
