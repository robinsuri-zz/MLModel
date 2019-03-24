package machinelearning;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class MachineLearningPlatform {
  private Set<MachineLearningModel> machineLearningModelSet;
  private Function<Set<Double>, Double> criteriaFunction;
  private Source input;
  private Source output;

  public MachineLearningPlatform(Set<MachineLearningModel> mlModelSet, Function<Set<Double>, Double> criteriaFunction, Source input, Source output) {
    this.machineLearningModelSet = mlModelSet;
    this.criteriaFunction = criteriaFunction;
    this.input = input;
    this.output = output;
  }

  public Set<MachineLearningModel> getMachineLearningModelSet() {
    return machineLearningModelSet;
  }

  public MachineLearningPlatform setMachineLearningModelSet(Set<MachineLearningModel> machineLearningModelSet) {
    this.machineLearningModelSet = machineLearningModelSet;
    return this;
  }

  public Function<Set<Double>, Double> getCriteriaFunction() {
    return criteriaFunction;
  }

  public MachineLearningPlatform setCriteriaFunction(Function<Set<Double>, Double> criteriaFunction) {
    this.criteriaFunction = criteriaFunction;
    return this;
  }

  public Source getInput() {
    return input;
  }

  public MachineLearningPlatform setInput(Source input) {
    this.input = input;
    return this;
  }

  public Source getOutput() {
    return output;
  }

  public MachineLearningPlatform setOutput(Source output) {
    this.output = output;
    return this;
  }

  public void execute() {
    List<Double> inputList = input.read();
//    List<Double>
//    for(MachineLearningModel machineLearningModel : MachineLearningModels) {
//      machineLearningModel.apply(inputList)
//    }
  }
}
