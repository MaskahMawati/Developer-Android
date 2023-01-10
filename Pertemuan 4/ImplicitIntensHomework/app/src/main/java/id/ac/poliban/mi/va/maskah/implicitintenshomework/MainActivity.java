package id.ac.poliban.mi.va.maskah.implicitintenshomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * The implicitIntents app contains three buttons for sending implicit intents:
 * - Open a URL in a browser
 * - Find a location on a map
 * - Share a text string
 */

public class MainActivity extends AppCompatActivity {

    private EditText wWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The currents state data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);
    }

    /**
     * Handles the onClick for the "Open Website" button. Get the URI
     * from the edit text and sends an implicit intent for that URL.
     *
     * @param view The view (Button) that was clicked.
     */
    public void openWebsite(View view) {
        // Get the URL text.
        String url = wWebsiteEditText.getText().toString();

        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    /**
     * Handles the onClick for the "Open Location" button. Gets the location.
     * text from the edit text and sends an implicit intent for that location.
     * <p>
     * The location text can be any searchable geographic location.
     *
     * @param view The view (Button) that was clicked.
     */
    public void openlocation(View view) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        String loc = mLocationEditText.getText().toString();

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}