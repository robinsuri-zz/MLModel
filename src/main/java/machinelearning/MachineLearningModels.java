package machinelearning;

import java.util.List;
import java.util.Set;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;

public class MachineLearningModels {
  private List<String> machineLearningModels;

  public static void main(String[] args) {
    Function<Set<Double>, Double> criteriaFunction = new Function<Set<Double>, Double>() {
      @Override
      public Double apply(Set<Double> doubles) {
        return null;
      }
    };
  }

  private Double criteria(Set<Double> accuracySet) {
    return null;
  }

  //this will take as input a criteriaFunction
  private Double sinkValue(Function<Set<Double>, Double> criteriaFunction,  Set<Double> accuracySet) {
    return criteriaFunction.apply(accuracySet);
  }
}


