package com.thomas.geoguesswipe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<GeoObject> geoObjects = new ArrayList<>();

        for (int i = 0; i < GeoObject.PRE_DEFINED_GEO_OBJECT_VALUES.length; i++) {
            geoObjects.add(new GeoObject(GeoObject.PRE_DEFINED_GEO_OBJECT_VALUES[i],
                    GeoObject.PRE_DEFINED_GEO_OBJECT_IMAGE_IDS[i], GeoObject.PRE_DEFINED_GEO_OBJECT_NAMES[i]));
        }

        final RecyclerView geoRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL);

        geoRecyclerView.setLayoutManager(layoutManager);
        final GeoObjectAdapter geoObjectAdapter = new GeoObjectAdapter(this, geoObjects);
        geoRecyclerView.setAdapter(geoObjectAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0 , ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int objectPosition = viewHolder.getLayoutPosition();
                GeoObject geoObject = geoObjectAdapter.listGeoObject.get(objectPosition);
                if (direction == ItemTouchHelper.RIGHT) {
                    if (!geoObject.getmGeoName()) {
                        showCorrect(true, geoObject.getGeoImageLocation());
                    } else {
                        showCorrect(false, geoObject.getGeoImageLocation());
                    }
                } else if (direction == ItemTouchHelper.LEFT ){
                    if (geoObject.getmGeoName()) {
                        showCorrect(true, geoObject.getGeoImageLocation());
                    } else {
                        showCorrect(false, geoObject.getGeoImageLocation());
                    }
                }
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(geoRecyclerView);

    }

    private void showCorrect(boolean correct, String answer) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        if (correct) {
            CharSequence text = "Correct! it's " + answer;
            toast = Toast.makeText(context, text, duration);
        } else {
            CharSequence text = "Wrong. it's " + answer;
            toast = Toast.makeText(context, text, duration);
        }
        toast.show();
    }


}
