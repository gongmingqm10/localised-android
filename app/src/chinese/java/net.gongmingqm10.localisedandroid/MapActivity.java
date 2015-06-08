package net.gongmingqm10.localisedandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amap.api.maps2d.MapView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MapActivity extends AppCompatActivity {

    @InjectView(R.id.map)
    protected MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_map);
        ButterKnife.inject(this);
        mapView.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
