package gsi.reyst.rx.step.by.step.DI;

import android.content.Context;

public class TestComponentHolder extends ComponentHolder {

    protected TestComponentHolder(Context context) {
        super(context);

        mAppComponent = DaggerTestAppComponent.builder() // не генерится
                .build();

        create(this);
    }


}
