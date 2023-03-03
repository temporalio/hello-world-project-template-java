// @@@SNIPSTART hello-world-project-template-java-activity-interface
package helloworldapp;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface HelloWorldActivity {

    // Define your activity method which can be called during workflow execution
    @ActivityMethod
    String composeGreeting(String name);
    
}
// @@@SNIPEND
