package gsi.reyst.rx.step.by.step.DI;

import android.app.Application;
import android.content.Context;

import gsi.reyst.rx.step.by.step.App;
import gsi.reyst.rx.step.by.step.DI.components.AppComponent;
import gsi.reyst.rx.step.by.step.DI.components.DaggerAppComponent;
import gsi.reyst.rx.step.by.step.DI.components.RepoInfoComponent;
import gsi.reyst.rx.step.by.step.DI.components.RepoListComponent;
import gsi.reyst.rx.step.by.step.DI.modules.AppModule;
import gsi.reyst.rx.step.by.step.DI.modules.MappersModule;
import gsi.reyst.rx.step.by.step.DI.modules.ModelModule;
import gsi.reyst.rx.step.by.step.DI.modules.RepoInfoModule;
import gsi.reyst.rx.step.by.step.DI.modules.RepoListModule;
import gsi.reyst.rx.step.by.step.model.VO.Repository;
import gsi.reyst.rx.step.by.step.views.RepoInfoView;
import gsi.reyst.rx.step.by.step.views.RepoListView;

public class ComponentHolder {

    private static ComponentHolder sInstance;

    private AppComponent mAppComponent;

    public static ComponentHolder getInstance() {
        if (sInstance == null) {
            sInstance = new ComponentHolder();
        }
        return sInstance;
    }

    protected ComponentHolder() {
    }

    public void initComponentHolder(Application application) {

        assert mAppComponent == null;

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .mappersModule(new MappersModule())
                .modelModule(new ModelModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public RepoListComponent getRepoListComponent(RepoListView view) {
        return mAppComponent.plus(new RepoListModule(view));
    }

    public RepoInfoComponent getRepoInfoComponent(RepoInfoView view, Repository repo) {
        return mAppComponent.plus(new RepoInfoModule(view, repo));
    }

}
