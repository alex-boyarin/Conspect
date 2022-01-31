package cucumberExample;

import io.cucumber.java.en.Given;

public class StepDefinitions {
    @Given("I have {int} cukes in my belly")
    public void i_have_cukes_in_my_belly(int cukes){
        System.out.format("Cuces: %n\n", cukes);
    }
}
