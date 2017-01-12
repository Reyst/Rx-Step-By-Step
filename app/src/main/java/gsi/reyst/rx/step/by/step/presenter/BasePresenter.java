package gsi.reyst.rx.step.by.step.presenter;

import java.util.List;

import javax.inject.Inject;

import gsi.reyst.rx.step.by.step.DI.ComponentHolder;
import gsi.reyst.rx.step.by.step.model.Model;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter implements Presenter {

    @Inject
    protected Model dataRepository;

    public BasePresenter() {
        ComponentHolder.getInstance().getAppComponent().inject(this);
    }

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    protected void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }

    public boolean isListEmpty(List list) {
        return list == null || list.isEmpty();
    }
}
