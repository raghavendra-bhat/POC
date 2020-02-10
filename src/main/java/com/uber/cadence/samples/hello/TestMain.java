package com.uber.cadence.samples.hello;

import static com.uber.cadence.samples.common.SampleConstants.DOMAIN;

import com.uber.cadence.client.WorkflowClient;
import java.util.List;

public class TestMain {
  public static void main(String[] args) {
    System.out.println("**********************************test");
    WorkflowClient workflowClient = WorkflowClient.newInstance(DOMAIN);

    HelloSignal.GreetingWorkflow workflowById =
        workflowClient.newWorkflowStub(HelloSignal.GreetingWorkflow.class, "nIMXLKfttZ");
    workflowById.waitForName("Universe"); // sends waitForName signal
    workflowById.exit();

    // Calling synchronous getGreeting after workflow has started reconnects to the existing
    // workflow and blocks until a result is available. Note that this behavior assumes that
    // WorkflowOptions are not configured with WorkflowIdReusePolicy.AllowDuplicate. In that case
    // the call would fail with WorkflowExecutionAlreadyStartedException.
    List<String> greetings = workflowById.getGreetings();
    System.out.println(greetings);
  }
}
