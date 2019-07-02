package com.dns.buggylock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.omadahealth.lollipin.lib.managers.AppLock;
import com.github.omadahealth.lollipin.lib.managers.LockManager;
import com.muddzdev.styleabletoast.StyleableToast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ENABLE = 11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(MainActivity.this, CustomPinActivity.class);

        final Button enablePinlockButton = findViewById(R.id.button_enable_pinlock);
        enablePinlockButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pinLockOperationOn();
            }
        });

        final Button disablePinlockButton = findViewById(R.id.button_disable_pinlock);
        disablePinlockButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pinLockOperationOff();
            }
        });

        final Button changePinlockButton = findViewById(R.id.button_change_pinlock);
        changePinlockButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra(AppLock.EXTRA_TYPE, AppLock.CHANGE_PIN);
                startActivity(intent);
            }
        });

        final Button viewProtectedActivityButton = findViewById(R.id.button_view_protected_activity);
        viewProtectedActivityButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                StyleableToast.makeText(getApplicationContext(), "Launching Pin Protected Activity!", R.style.greenColor1).show();
                Intent intent = new Intent(MainActivity.this, ProtectedActivity.class);
                startActivity(intent);
            }
        });
    }
    public void pinLockOperationOn() {

        //init
        LockManager<CustomPinActivity> lockManager = LockManager.getInstance();
        lockManager.enableAppLock(getApplicationContext(), CustomPinActivity.class);
        lockManager.getAppLock().setLogoId(R.drawable.lock100);

        // Enable the lock
        Intent intent = new Intent(getApplicationContext(), CustomPinActivity.class);
        intent.putExtra(AppLock.EXTRA_TYPE, AppLock.ENABLE_PINLOCK);
        startActivityForResult(intent, REQUEST_CODE_ENABLE);
    }

    public void pinLockOperationOff() {
        // Disable the Lock
        LockManager<CustomPinActivity> lockManager = LockManager.getInstance();
        lockManager.getAppLock().disableAndRemoveConfiguration();
        StyleableToast.makeText(getApplicationContext(), "PinLock Disabled", R.style.redColor2).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQUEST_CODE_ENABLE:
                StyleableToast.makeText(getApplicationContext(), "PinLock Enabled!", R.style.greenColor1).show();
                break;
        }
    }
}
