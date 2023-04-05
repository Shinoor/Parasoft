package runner;

import org.testng.annotations.DataProvider;

public interface TTestRunner {
    @DataProvider(parallel = true)
    Object[][] scenario();
}
