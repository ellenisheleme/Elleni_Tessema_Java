package monthandmathservice.model;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class MathSolution {
    @NotNull(message = "The operand can not be empty and should a be number")
    private String operand1;
    @NotNull(message = "The operand can not be empty and should a be number")
    private String  operand2;

    private String operation;
    private int answer;

    public MathSolution(String operand1, String operand2, String operation, int answer) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.answer = answer;
    }

    public MathSolution(String operand1, String operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public MathSolution() {
    }

    public String getOperand1() {
        return operand1;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "MathSolution{" +
                "operand1='" + operand1 + '\'' +
                ", operand2='" + operand2 + '\'' +
                ", operation='" + operation + '\'' +
                ", answer=" + answer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathSolution solution = (MathSolution) o;
        return answer == solution.answer && Objects.equals(operand1, solution.operand1) && Objects.equals(operand2, solution.operand2) && Objects.equals(operation, solution.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, operation, answer);
    }
}
