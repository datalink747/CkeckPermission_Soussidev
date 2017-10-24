# Ckeck Runtime Permission Soussidev
<br>

[![Ansible Role](https://img.shields.io/badge/Developer-Soussidev-yellow.svg)]()
[![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)]()

<a href='https://ko-fi.com/A243447K' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi4.png?v=0' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a>

# Code :
> btn Phone 
```java

        check_Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{CALL_PHONE}, PERMISSION_REQUEST_CODE_PHONE);
            }
        });

```

> Function onRequestPermissionsResult
```java

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

```

# SDK Required
+ Target sdk:<br>
[![API](https://img.shields.io/badge/API-23%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=26)
+ Min sdk:<br>
[![API](https://img.shields.io/badge/API-19%2B-orange.svg?style=flat)](https://android-arsenal.com/api?level=19)

# Social Media
<table style="border:0px;">
   <tr>
      <td>
<a href="https://www.linkedin.com/in/soussimohamed/">
<img src="picture/linkedin.png" height="100" width="100" alt="Soussi Mohamed">
</a>
      </td>
      <td>
         <a href="https://twitter.com/soussimohamed7/">
<img src="picture/Twitter.png" height="60" width="60" alt="Soussi Mohamed">
</a>
     </td>
           <td>
         <a href="https://plus.google.com/u/0/+SoussiMohamed747">
<img src="picture/googleplus.png" height="60" width="60" alt="Soussi Mohamed">
</a>
     </td>
  </tr> 
</table>  

# Licence
```
Copyright 2017 Soussidev, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
