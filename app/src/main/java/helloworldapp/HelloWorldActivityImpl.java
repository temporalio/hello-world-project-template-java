// @@@SNIPSTART hello-world-project-template-java-activity
package helloworldapp;

public class HelloWorldActivityImpl implements HelloWorldActivity {

    @Override
    public String composeGreeting(String name) {
        return "Hello " + name + "!";
    }

}
// @@@SNIPEND
