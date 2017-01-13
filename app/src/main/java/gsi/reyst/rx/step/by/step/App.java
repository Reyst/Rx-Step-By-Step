package gsi.reyst.rx.step.by.step;

import android.app.Application;

import gsi.reyst.rx.step.by.step.DI.ComponentHolder;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponents();
    }

    protected void initializeComponents() {
        ComponentHolder.getInstance().initComponentHolder(this);
    }

}
