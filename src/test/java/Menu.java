import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.util.Scanner;

public class Menu {

    /*public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the SauceDemo Test Automation");
        System.out.println("Please select a test to run:");
        System.out.println("0. Driver Factory Test");
        System.out.println("1. Login Test");
        System.out.println("2. Main page Test");
        System.out.println("3. Login Test with User");
        System.out.println("4. Main page Test with User");

        int option = scanner.nextInt();

        switch (option) {
            case 0:
                DriverFactoryTest.class;
                break;
            case 1:
                //LoginPageTest.main(null);
                break;
            case 2:
                //MainPageTest.main(null);
                break;
            case 3:
                //LoginPageTestWithUser.main(null);
                break;
            case 4:
                //MainPageTestWithUser.main(null);
                break;
            default:

                System.out.println("Invalid option. Please select a number between 0 and 4.");
        }

    }*/

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione el test:");
        System.out.println("1. DriverFactoryTest");
        System.out.println("2. LoginTest");

        int opcion = sc.nextInt();

        Class<?> testClass = null;

        switch (opcion) {
            case 1 -> {
                System.out.println("Running DriverFactoryTest...");
                testClass = DriverFactoryTest.class;
            }
            //case 2 -> "DriverFactoryTest";
            //default -> null;
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
