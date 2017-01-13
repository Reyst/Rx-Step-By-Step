package gsi.reyst.rx.step.by.step;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import gsi.reyst.rx.step.by.step.views.fragments.BaseFragment;
import gsi.reyst.rx.step.by.step.views.fragments.RepoInfoFragment;
import gsi.reyst.rx.step.by.step.views.fragments.RepoListFragment;

public class MainActivity extends AppCompatActivity implements FragmentChanger {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getFragmentManager().findFragmentById(R.id.activity_main) == null) {
            try {
                changeFragment(getFragmentInstance(BaseFragment.TYPE_REPOSITORY_LIST, null), false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public BaseFragment getFragmentInstance(int fragmentType, Bundle params) throws Exception {

        BaseFragment result = null;

        switch (fragmentType) {
            case BaseFragment.TYPE_REPOSITORY_LIST:
                result = RepoListFragment.getInstance(params);
                break;
            case BaseFragment.TYPE_REPOSITORY_INFO:
                result = RepoInfoFragment.getInstance(params);
                break;
        }

        if (result == null) {
            throw new Exception("Incorrect fragment type");
        }
        return result;
    }

    @Override
    public void changeFragment(BaseFragment newFragment, boolean saveHistory) {
        FragmentTransaction tx = getFragmentManager().beginTransaction();
        tx.replace(R.id.activity_main, newFragment);
        if (saveHistory) tx.addToBackStack(null);
        tx.commit();
    }
}
