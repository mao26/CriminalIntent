package com.olivergamesllc.criminalintent;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by mario_oliver93 on 9/29/16.
 */

public class CrimeLab {
    private static final String TAG = "package.CrimeLab";
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context){
        //the arraylist <> blank diamonds infer from the declaration the type of objects it will hold
        mCrimes = new ArrayList<>();
        generateDefaultCrimes();
    }

    private List<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for(Crime crime: mCrimes){
            if(crime.getId() == id){
                return crime;
            }
        }
        Log.i(TAG, "crime search for does not exist");
        return null;
    }

    private void generateDefaultCrimes(){
        for(int i = 0; i < 100; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime #"+i);
            crime.setSolved(i % 2 == 0);
            mCrimes.add(crime);
        }
    }

}
