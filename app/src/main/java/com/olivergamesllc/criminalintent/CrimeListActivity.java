package com.olivergamesllc.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by mario_oliver93 on 9/29/16.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
