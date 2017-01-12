package gsi.reyst.rx.step.by.step.DI.components;


import dagger.Component;
import gsi.reyst.rx.step.by.step.DI.modules.AppModuleTest;
import gsi.reyst.rx.step.by.step.DI.modules.MappersModule;
import gsi.reyst.rx.step.by.step.mappers.MappersTest;

@Component(modules = {AppModuleTest.class, MappersModule.class})
public interface TestAppComponent extends AppComponent {

    void inject(MappersTest mappersTest);

}
