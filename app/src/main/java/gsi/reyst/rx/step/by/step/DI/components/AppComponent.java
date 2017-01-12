package gsi.reyst.rx.step.by.step.DI.components;

import javax.inject.Singleton;

import dagger.Component;
import gsi.reyst.rx.step.by.step.DI.modules.AppModule;
import gsi.reyst.rx.step.by.step.DI.modules.MappersModule;
import gsi.reyst.rx.step.by.step.DI.modules.ModelModule;
import gsi.reyst.rx.step.by.step.DI.modules.RepoInfoModule;
import gsi.reyst.rx.step.by.step.DI.modules.RepoListModule;
import gsi.reyst.rx.step.by.step.model.ModelImpl;
import gsi.reyst.rx.step.by.step.presenter.BasePresenter;
import gsi.reyst.rx.step.by.step.presenter.RepoInfoPresenter;
import gsi.reyst.rx.step.by.step.presenter.RepoListPresenter;

@Singleton
@Component(modules = {
        AppModule.class,
        MappersModule.class,
        ModelModule.class})
public interface AppComponent {

    void inject(BasePresenter presenter);

    void inject(ModelImpl model);

    void inject(RepoListPresenter presenter);

    void inject(RepoInfoPresenter presenter);

    RepoInfoComponent plus(RepoInfoModule module);

    RepoListComponent plus(RepoListModule module);

}
