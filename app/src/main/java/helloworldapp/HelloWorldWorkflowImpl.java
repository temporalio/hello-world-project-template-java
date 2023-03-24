// @@@SNIPSTART hello-world-project-template-java-workflow
package helloworldapp;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class HelloWorldWorkflowImpl implements HelloWorldWorkflow {

    /* 
     * At least one of the following options needs to be defined:
     * - setStartToCloseTimeout
     * - setScheduleToCloseTimeout
     */
    ActivityOptions options = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(60))
            .build();

    /*
     * Define the HelloWorldActivity stub. Activity stubs are proxies for activity invocations that
     * are executed outside of the workflow thread on the activity worker, that can be on a
     * different host. Temporal is going to dispatch the activity results back to the workflow and
     * unblock the stub as soon as activity is completed on the activity worker.
     * 
     * The activity options that were defined above are passed in as a parameter.
     */
    private final HelloWorldActivities activity = Workflow.newActivityStub(HelloWorldActivities.class, options);

    // This is the entry point to the Workflow.
    @Override
    public String getGreeting(String name) {

        /**   
         * If there were other Activity methods they would be orchestrated here or from within other Activities.
         * This is a blocking call that returns only after the activity has completed.
         */
        return activity.composeGreeting(name);
    }
}
// @@@SNIPEND
