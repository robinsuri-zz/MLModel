package machinelearning;

import java.util.List;

public interface MachineLearningModel {
  public Double apply(List<Double> inputList);

}
