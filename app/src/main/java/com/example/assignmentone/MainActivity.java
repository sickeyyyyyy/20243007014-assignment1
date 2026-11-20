package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity is the CampusLife home screen. It shows the welcome banner and
 * the four service buttons (Facilities, Events, Clubs, Support).
 *
 * Clicking a button starts {@link DetailActivity} and passes the selected
 * topic's position in the arrays.xml arrays plus its display label through an
 * explicit Intent.
 */
public class MainActivity extends AppCompatActivity {

    /** Intent extra key: position of the selected topic in the resource arrays. */
    public static final String EXTRA_TOPIC_INDEX = "topic_index";
    /** Intent extra key: service label shown in the detail screen header. */
    public static final String EXTRA_TOPIC_LABEL = "topic_label";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Locate the four service buttons declared in activity_main.xml.
        ImageButton btnFacilities = findViewById(R.id.btnFacilities);
        ImageButton btnEvents = findViewById(R.id.btnEvents);
        ImageButton btnClubs = findViewById(R.id.btnClubs);
        ImageButton btnSupport = findViewById(R.id.btnSupport);

        // Attach a click listener to each button. The index matches the order
        // of the items in the three arrays inside res/values/arrays.xml.
        btnFacilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetail(0, getString(R.string.label_facilities));
            }
        });

        btnEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetail(1, getString(R.string.label_events));
            }
        });

        btnClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetail(2, getString(R.string.label_clubs));
            }
        });

        btnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetail(3, getString(R.string.label_support));
            }
        });
    }

    private void openDetail(int index, String label) {
        // Explicit Intent: target the DetailActivity class directly.
        Intent intent = new Intent(this, DetailActivity.class);
        // Pass the unique identifier (array index) and the header label.
        intent.putExtra(EXTRA_TOPIC_INDEX, index);
        intent.putExtra(EXTRA_TOPIC_LABEL, label);
        startActivity(intent);
    }
}
