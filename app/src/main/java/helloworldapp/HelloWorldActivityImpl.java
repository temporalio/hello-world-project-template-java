// @@@SNIPSTART hello-world-project-template-java-activity
package helloworldapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldActivityImpl implements HelloWorldActivity {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldActivityImpl.class);
    @Override
    public String composeGreeting(String name) {
        log.info("Composing greeting...");
        return "Hello " + name + "!";
    }

}
// @@@SNIPEND
