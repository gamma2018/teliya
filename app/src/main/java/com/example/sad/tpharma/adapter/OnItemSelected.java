package com.example.sad.tpharma.adapter;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by SADGC on 10/6/2016.
 */
public abstract class OnItemSelected implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        onItemSelected(editable.toString());
    }
    protected abstract void onItemSelected(String string);
}
