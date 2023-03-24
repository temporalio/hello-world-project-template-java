// @@@SNIPSTART hello-world-project-template-java-activity-interface
package helloworldapp;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface HelloWorldActivities {

    // Define your activity methods which can be called during workflow execution
    String composeGreeting(String name);
    
}
// @@@SNIPEND
