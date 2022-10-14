package monthandmathservice.controller;
import monthandmathservice.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController

public class MathSolutionController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution addTheTwoOperands(@RequestBody @Valid MathSolution operand) {

        MathSolution mathSolution = new MathSolution();

        mathSolution.setOperand1(operand.getOperand1());
        mathSolution.setOperand2(operand.getOperand2());
        mathSolution.setOperation("add");
        mathSolution.setAnswer(Integer.parseInt(operand.getOperand1())+Integer.parseInt(operand.getOperand2()));

        return mathSolution;

    }
    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution differenceOfTheTwoOperands(@RequestBody @Valid MathSolution operand) {

        MathSolution mathSolution = new MathSolution();

        mathSolution.setOperand1(operand.getOperand1());
        mathSolution.setOperand2(operand.getOperand2());
        mathSolution.setOperation("subtract");
        mathSolution.setAnswer(Integer.parseInt(operand.getOperand1())- Integer.parseInt(operand.getOperand2()));

        return mathSolution;

    }
    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution quotientOfTheTwoOperands(@RequestBody @Valid MathSolution operand) {

        MathSolution mathSolution = new MathSolution();

        mathSolution.setOperand1(operand.getOperand1());
        mathSolution.setOperand2(operand.getOperand2());
        mathSolution.setOperation("divide");
        mathSolution.setAnswer(Integer.parseInt(operand.getOperand1())/Integer.parseInt(operand.getOperand2()));

        return mathSolution;

    }
    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution productOfTheTwoOperands(@RequestBody @Valid MathSolution operand) {

        MathSolution mathSolution = new MathSolution();

        mathSolution.setOperand1(operand.getOperand1());
        mathSolution.setOperand2(operand.getOperand2());
        mathSolution.setOperation("multiply");
        mathSolution.setAnswer(Integer.parseInt(operand.getOperand1()) * Integer.parseInt(operand.getOperand2()));

        return mathSolution;
    }




}
