package com.dns.buggylock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.omadahealth.lollipin.lib.PinActivity;

public class ProtectedActivity extends PinActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protected);
    }
}