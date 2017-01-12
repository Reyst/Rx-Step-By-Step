package gsi.reyst.rx.step.by.step.DI.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gsi.reyst.rx.step.by.step.TestUtils;

@Module
public class AppModuleTest {

    @Singleton
    @Provides
    public TestUtils getTestUtils() {
        return new TestUtils();
    }

}
