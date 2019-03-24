package machinelearning;

import java.util.Set;
import java.util.function.Function;

public class Main {
  private static MachineLearningPlatform machineLearningPlatform;

  public static void main(String[] args) {
    Set<MachineLearningModel> machineLearningModelSet = null;
    Function<Set<Double>, Double> criteriaFunction = new Function<Set<Double>, Double>() {
      @Override
      public Double apply(Set<Double> doubles) {
        return 0d;
      }
    };
    FileSource inputSource = new FileSource("./input");
    FileSource outputSource = new FileSource("./output");

    machineLearningPlatform = new MachineLearningPlatform(machineLearningModelSet, criteriaFunction,inputSource, outputSource);
    machineLearningPlatform.execute();

  }
}

