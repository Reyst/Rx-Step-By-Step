package gsi.reyst.rx.step.by.step.views.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

import gsi.reyst.rx.step.by.step.FragmentChanger;
import gsi.reyst.rx.step.by.step.presenter.BasePresenter;

public abstract class BaseFragment extends Fragment {

    public static final int TYPE_REPOSITORY_LIST = 1;
    public static final int TYPE_REPOSITORY_INFO = 2;

    protected abstract BasePresenter getPresenter();

    private FragmentChanger mChanger;

    public void setFragmentChanger(FragmentChanger changer) {
        mChanger = changer;
    }

    public FragmentChanger getFragmentChanger() {
        return mChanger;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onStop() {
        super.onStop();

        BasePresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    public void showError(String error) {
        makeToast(error);
    }

    protected void makeToast(String string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
    }


}
