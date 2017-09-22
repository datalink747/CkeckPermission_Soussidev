package com.soussidev.kotlin.ckeckpermission_soussidev;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.ACCOUNT_MANAGER;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.SEND_SMS;
import static android.Manifest.permission.WRITE_CALENDAR;
import static android.Manifest.permission.WRITE_CONTACTS;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    private Button verify_permission,check_permisiions,check_Phone,check_SMS,check_record,check_contact,check_calendar,check_storage;
    private static final int PERMISSION_REQUEST_CODE = 200;
    private static final int PERMISSION_REQUEST_CODE_PHONE = 400;
    private static final int PERMISSION_REQUEST_CODE_SMS = 300;
    private static final int PERMISSION_REQUEST_CODE_RECORD = 600;
    private static final int PERMISSION_REQUEST_CODE_CALENDAR = 100;
    private static final int PERMISSION_REQUEST_CODE_STORAGE = 700;
    private static final int PERMISSION_REQUEST_CODE_CONTACT = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init View
        verify_permission = (Button)findViewById(R.id.btn_verif_permission);
        check_permisiions = (Button)findViewById(R.id.btn_check_permissions);

        check_Phone = (Button)findViewById(R.id.btn_check_permission_camera);
        check_SMS = (Button)findViewById(R.id.btn_check_permission_sms);
        check_contact = (Button)findViewById(R.id.btn_contact);
        check_calendar = (Button)findViewById(R.id.btn_calendar);
        check_record = (Button)findViewById(R.id.btn_record_audio);
        check_storage = (Button)findViewById(R.id.btn_storage);

        //btn Verify Permission is Enable or Disable
        verify_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (VerifyPermission()) {

                    Toast.makeText(MainActivity.this,"Permission is Enable",Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(MainActivity.this,"Please Check your Permissions !",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //btn check Permission Camera and Access Location fine
        check_permisiions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{ACCESS_FINE_LOCATION, CAMERA}, PERMISSION_REQUEST_CODE);
            }
        });

        //btn Phone
        check_Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{CALL_PHONE}, PERMISSION_REQUEST_CODE_PHONE);
            }
        });

        //btn SMS
        check_SMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{SEND_SMS}, PERMISSION_REQUEST_CODE_SMS);
            }
        });

        //btn Record Audio
        check_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{RECORD_AUDIO}, PERMISSION_REQUEST_CODE_RECORD);
            }
        });

        //btn Storage
        check_storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE_STORAGE);
            }
        });

        //btn Calendar
        check_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{WRITE_CALENDAR}, PERMISSION_REQUEST_CODE_CALENDAR);
            }
        });

        //btn Contact
        check_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{WRITE_CONTACTS}, PERMISSION_REQUEST_CODE_CONTACT);
            }
        });
    }

    /**
     * @author Soussi
     *
     * Checks for VerifyPermission
     */
    private boolean VerifyPermission() {
        int result_location = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION);
        int result_camera = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA);
        int result_account = ContextCompat.checkSelfPermission(getApplicationContext(), ACCOUNT_MANAGER);

        return result_location == PackageManager.PERMISSION_GRANTED && result_camera == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * @author Soussi
     *
     * @param grantResults
     * @param permissions
     * @param requestCode
     *
     * Function onRequestPermissionsResult
     */

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            // Permission for Camera and Access Fine Location
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {

                    boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (locationAccepted && cameraAccepted)

                    Toast.makeText(MainActivity.this,"Permission Granted !",Toast.LENGTH_SHORT).show();
                    else {

                        Toast.makeText(MainActivity.this,"Permission Denied !",Toast.LENGTH_SHORT).show();

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION)) {
                                showMessageOKCancel("You need to allow access Now !",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{ACCESS_FINE_LOCATION, CAMERA},
                                                            PERMISSION_REQUEST_CODE);
                                                }
                                            }
                                        });
                                return;
                            }
                        }

                    }
                }


                break;
            // Permission for SMS
            case PERMISSION_REQUEST_CODE_SMS :
                if (grantResults.length > 0) {

                    boolean SmsAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;


                    if (SmsAccepted )

                        Toast.makeText(MainActivity.this,"Permission Granted for SMS!",Toast.LENGTH_SHORT).show();
                    else {

                        Toast.makeText(MainActivity.this,"Permission Denied for SMS!",Toast.LENGTH_SHORT).show();

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(SEND_SMS)) {
                                showMessageOKCancel("You need to allow access Now !",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{SEND_SMS},
                                                            PERMISSION_REQUEST_CODE_SMS);
                                                }
                                            }
                                        });
                                return;
                            }
                        }

                    }
                }


                break;
            // Permission for Phone
            case PERMISSION_REQUEST_CODE_PHONE :
                if (grantResults.length > 0) {

                    boolean PhoneAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;


                    if (PhoneAccepted )

                        Toast.makeText(MainActivity.this,"Permission Granted for Phone!",Toast.LENGTH_SHORT).show();
                    else {

                        Toast.makeText(MainActivity.this,"Permission Denied for Phone!",Toast.LENGTH_SHORT).show();

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(CALL_PHONE)) {
                                showMessageOKCancel("You need to allow access Now !",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{CALL_PHONE},
                                                            PERMISSION_REQUEST_CODE_PHONE);
                                                }
                                            }
                                        });
                                return;
                            }
                        }

                    }
                }


                break;
            // Permission for Calendar
            case PERMISSION_REQUEST_CODE_CALENDAR :
                if (grantResults.length > 0) {

                    boolean CalendarAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;


                    if (CalendarAccepted )

                        Toast.makeText(MainActivity.this,"Permission Granted for Calander!",Toast.LENGTH_SHORT).show();
                    else {

                        Toast.makeText(MainActivity.this,"Permission Denied for Calendar!",Toast.LENGTH_SHORT).show();

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(WRITE_CALENDAR)) {
                                showMessageOKCancel("You need to allow access Now !",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{WRITE_CALENDAR},
                                                            PERMISSION_REQUEST_CODE_CALENDAR);
                                                }
                                            }
                                        });
                                return;
                            }
                        }

                    }
                }


                break;
            // Permission for Contact
            case PERMISSION_REQUEST_CODE_CONTACT :
                if (grantResults.length > 0) {

                    boolean ContactAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;


                    if (ContactAccepted )

                        Toast.makeText(MainActivity.this,"Permission Granted for Contact!",Toast.LENGTH_SHORT).show();
                    else {

                        Toast.makeText(MainActivity.this,"Permission Denied for Contact!",Toast.LENGTH_SHORT).show();

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(WRITE_CONTACTS)) {
                                showMessageOKCancel("You need to allow access Now !",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{WRITE_CONTACTS},
                                                            PERMISSION_REQUEST_CODE_CONTACT);
                                                }
                                            }
                                        });
                                return;
                            }
                        }

                    }
                }


                break;
            // Permission for Record Audio
            case PERMISSION_REQUEST_CODE_RECORD :
                if (grantResults.length > 0) {

                    boolean RecordAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;


                    if (RecordAccepted )

                        Toast.makeText(MainActivity.this,"Permission Granted for Record!",Toast.LENGTH_SHORT).show();
                    else {

                        Toast.makeText(MainActivity.this,"Permission Denied for Record!",Toast.LENGTH_SHORT).show();

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(RECORD_AUDIO)) {
                                showMessageOKCancel("You need to allow access Now !",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{RECORD_AUDIO},
                                                            PERMISSION_REQUEST_CODE_RECORD);
                                                }
                                            }
                                        });
                                return;
                            }
                        }

                    }
                }
             break;
            // Permission for Storage
            case PERMISSION_REQUEST_CODE_STORAGE :
                if (grantResults.length > 0) {

                    boolean StorageAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;


                    if (StorageAccepted )

                        Toast.makeText(MainActivity.this,"Permission Granted for Storage!",Toast.LENGTH_SHORT).show();
                    else {

                        Toast.makeText(MainActivity.this,"Permission Denied for Storage!",Toast.LENGTH_SHORT).show();

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)) {
                                showMessageOKCancel("You need to allow access Now !",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE},
                                                            PERMISSION_REQUEST_CODE_STORAGE);
                                                }
                                            }
                                        });
                                return;
                            }
                        }

                    }
                }
                break;
        }
    }

    /**
     * @author Soussi
     *
     * @param message
     * @param okListener
     * Function showMessageOKCancel
     */

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

}
