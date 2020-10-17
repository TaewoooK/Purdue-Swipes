package com.purdue.helloworld;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import static androidx.core.content.ContextCompat.startActivity;

public class utility {

    public static void openMaps(String coordinates, Context context) {
        Uri gmmIntentUri = Uri.parse(coordinates);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        context.startActivity(mapIntent);
        // test test
    }
}
