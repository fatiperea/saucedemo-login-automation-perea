import legacy.LoginPageTest;
import legacy.MainPageTest;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select test:");
        System.out.println("1. DriverFactoryTest");
        System.out.println("2. Login Page Test");
        System.out.println("3. Main Page Test");
        System.out.println("4. Login Test with User");
        System.out.println("5. Main page Test with User");

        int option = sc.nextInt();

        Class<?> testClass = null;

        switch (option) {
            case 1 -> {
                System.out.println("Running DriverFactoryTest...");
                testClass = DriverFactoryTest.class;
            }
            case 2 -> {
                System.out.println("Running LoginPageTest...");
                testClass = LoginPageTest.class;
            }
            case 3 -> {
                System.out.println("Running MainPageTest...");
                testClass = MainPageTest.class;
            }
            case 4 -> {
                System.out.println("Running LoginPageTestWithUser...");
                testClass = LoginPageTestWithUser.class;
            }
            case 5 -> {
                System.out.println("Running MainPageTestWithUser...");
                testClass = MainPageTestWithUser.class;
            }
            default -> System.out.println("Invalid Option");
        };

        if (testClass != null) {
            LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                    .selectors(DiscoverySelectors.selectClass(testClass))
                    .build();

            Launcher launcher = LauncherFactory.create();
            SummaryGeneratingListener listener = new SummaryGeneratingListener();
            launcher.execute(request, listener);

            TestExecutionSummary summary = listener.getSummary();
            System.out.println("Tests found: " + summary.getTestsFoundCount());
            System.out.println("Successful: " + summary.getTestsSucceededCount());
            System.out.println("Failed: " + summary.getTestsFailedCount());

            summary.getFailures().forEach(failure -> {
                System.out.println("Failed: " + failure.getTestIdentifier().getDisplayName());
                System.out.println("Cause: " + failure.getException().getMessage());
            });
        }
        sc.close();
    }

}
