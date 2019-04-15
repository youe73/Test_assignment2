import org.junit.gen5.launcher.TestExecutionListener;
import org.junit.gen5.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class ownTestLauncher {

    public static void main(String[] args) {
        // Discover and filter tests
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(selectPackage("Assignment"),
                        selectClass(bankaccountTest.class))
                .filters(includeClassNamePatterns(".*Test")).build();

        Launcher launcher = LauncherFactory.create();
        TestPlan plan = launcher.discover(request);

        // Executing tests
        TestExecutionListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners((org.junit.platform.launcher.TestExecutionListener) listener);

        launcher.execute(request, (org.junit.platform.launcher.TestExecutionListener) listener);
    }

}
