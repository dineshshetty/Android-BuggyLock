package com.dns.buggylock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.muddzdev.styleabletoast.StyleableToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button enablePinlockButton = findViewById(R.id.button_enable_pinlock);
        enablePinlockButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                StyleableToast.makeText(getApplicationContext(), "PinLock Enabled!", R.style.greenColor1).show();

            }
        });

        final Button disablePinlockButton = findViewById(R.id.button_disable_pinlock);
        disablePinlockButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                StyleableToast.makeText(getApplicationContext(), "PinLock Disabled!", R.style.greenColor1).show();

            }
        });

        final Button changePinlockButton = findViewById(R.id.button_change_pinlock);
        changePinlockButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                StyleableToast.makeText(getApplicationContext(), "PinLock Changed!", R.style.greenColor1).show();

            }
        });

        final Button viewProtectedActivityButton = findViewById(R.id.button_view_protected_activity);
        viewProtectedActivityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                StyleableToast.makeText(getApplicationContext(), "Launching Pin Protected Activity!", R.style.greenColor1).show();
            }
        });
    }
}
