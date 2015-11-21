package com.anselmopfeifer.htapp.activities;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anselmopfeifer.htapp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.ButterKnife;

/**
 * Created by Anselmo on 21/11/2015.
 */
public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    Marker marker;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
        MapFragment map = (MapFragment) getFragmentManager().findFragmentById(R.id.map_id);
        map.getMapAsync(this);

    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        googleMap.setMyLocationEnabled(true);
        googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                if (marker !=null){
                    marker.remove();
                }
                LatLng local = new LatLng(location.getLatitude(),location.getLongitude());
                marker = googleMap.addMarker(new MarkerOptions().position(local));
            }
        });

    }
}
