package gsi.reyst.rx.step.by.step.DI.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context mContext;
    private Application mApplication;

    public AppModule(Application application) {
        mContext = application.getApplicationContext();
        mApplication = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mContext;
    }

}
