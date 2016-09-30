package com.olivergamesllc.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by mario_oliver93 on 9/28/16.
 */

public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText mTitleEditField;
    private CheckBox mSolvedCheckBox;
    private Button mDateButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //notice that we do not inflate our layout view in fragments
        mCrime = new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View frag_view = inflater.inflate(R.layout.fragment_crime, container, false);

        //set the title field and set a listener to allow changes to the title
        mTitleEditField = (EditText) frag_view.findViewById(R.id.edit_text_crime_title);
        mTitleEditField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //mTitleEditField.setText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //set the button to be the current date and disable it from responding to user click
        mDateButton = (Button) frag_view.findViewById(R.id.button_crime_date);
        mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);

        //grab the checkbox and allow it to be updated to reflect if crime has been solved -- changes model information as well
        mSolvedCheckBox = (CheckBox) frag_view.findViewById(R.id.checkbox_crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        return frag_view;
    }
}
