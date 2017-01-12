package gsi.reyst.rx.step.by.step.DI.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gsi.reyst.rx.step.by.step.DI.ComponentHolder;

@Module
public class AppModule {

    private Context mContext;
    private ComponentHolder mComponentHolder;

    public AppModule(Context context, ComponentHolder holder) {
        mContext = context;
        mComponentHolder = holder;
    }

    @Provides
    @Singleton
    public Context getContext() {
        return mContext;
    }

    @Provides
    @Singleton
    public ComponentHolder getComponentHolder() {
        return mComponentHolder;
    }


}
