package com.example.assignmentandroidnangcao.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.assignmentandroidnangcao.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DiaChi extends FragmentActivity implements OnMapReadyCallback {
    SupportMapFragment mapFragment;
    GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_chi);

         mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

        @Override
        public void onMapReady(GoogleMap googleMap) {

        googleMap = googleMap;
            LatLng csHn = new LatLng(21.038069, 105.746888);
            LatLng csDn = new LatLng(16.075719, 108.170016);
            LatLng csCt = new LatLng(10.026813, 105.757331);
            LatLng csSg = new LatLng(10.852924, 106.629551);
            LatLng csTn = new LatLng(12.686900, 108.054365);

            googleMap.addMarker(new MarkerOptions().position(csHn)
                    .title("PFT Polytechnic " +"Hà nội" ));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(csHn));

            googleMap.addMarker(new MarkerOptions().position(csDn)
                    .title("PFT Polytechnic " +"Đà Nẵng" ));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(csDn));

            googleMap.addMarker(new MarkerOptions().position(csCt)
                    .title("PFT Polytechnic " +"Cần Thơ" ));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(csCt));

            googleMap.addMarker(new MarkerOptions().position(csSg)
                    .title("PFT Polytechnic " +"TP Hồ Chí Minh" ));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(csSg));

            googleMap.addMarker(new MarkerOptions().position(csTn)
                    .title("PFT Polytechnic " +"Thái Nguyên" ));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(csTn));
        }
}
