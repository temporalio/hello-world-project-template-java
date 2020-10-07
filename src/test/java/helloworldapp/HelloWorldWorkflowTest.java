// @@@SNIPSTART hello-world-project-template-java-workflow-test
package helloworldapp;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.testing.TestWorkflowEnvironment;
import io.temporal.worker.Worker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldWorkflowTest {

    private TestWorkflowEnvironment testEnv;
    private Worker worker;
    private WorkflowClient workflowClient;

    @Before
    public void setUp() {
        testEnv = TestWorkflowEnvironment.newInstance();
        worker = testEnv.newWorker(Shared.HELLO_WORLD_TASK_QUEUE);
        worker.registerWorkflowImplementationTypes(HelloWorldWorkflowImpl.class);
        workflowClient = testEnv.getWorkflowClient();
    }

    @After
    public void tearDown() {
        testEnv.close();
    }

    @Test
    public void testGetGreeting() {
        Format format = mock(Format.class);
        worker.registerActivitiesImplementations(format);
        testEnv.start();
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(Shared.HELLO_WORLD_TASK_QUEUE)
                .build();
        HelloWorldWorkflow workflow = workflowClient.newWorkflowStub(HelloWorldWorkflow.class, options);
        workflow.getGreeting("test");
        verify(format).composeGreeting(eq("test"));
    }
}
// @@@SNIPEND
