package gsi.reyst.rx.step.by.step;

import android.os.Bundle;

import gsi.reyst.rx.step.by.step.views.fragments.BaseFragment;

public interface FragmentChanger {

    BaseFragment getFragmentInstance(int fragmentType, Bundle params) throws Exception;

    void changeFragment(BaseFragment newFragment, boolean saveHistory);

}
