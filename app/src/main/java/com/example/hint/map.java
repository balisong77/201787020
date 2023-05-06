package com.example.hint;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;

import java.util.ArrayList;
import java.util.List;

public class map extends AppCompatActivity {

    public LocationClient mLocation;
    private MapView mapView;
    private BaiduMap map;
    private boolean isFirstLocate = true;

    private double latitude;
    private double longitude;
    private Button mbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLocation = new LocationClient(getApplicationContext());
        mLocation.registerLocationListener(new MylocationListener());
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_map);
        mapView = findViewById(R.id.bmapView);
        mbtn = findViewById(R.id.map_button);
        map = mapView.getMap();
        map.setMyLocationEnabled(true);
        List<String> permissionlist = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(com.example.hint.map.this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            permissionlist.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(com.example.hint.map.this, Manifest.permission.READ_PHONE_STATE) !=
                PackageManager.PERMISSION_GRANTED) {
            permissionlist.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(com.example.hint.map.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            permissionlist.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionlist.isEmpty()) {
            String[] permissions = permissionlist.toArray(new String[permissionlist.size()]);
            ActivityCompat.requestPermissions(com.example.hint.map.this, permissions, 1);
        } else {
            requestLocation();
        }
    }

    private void navigateTo(BDLocation location)  {
        MyLocationData.Builder builder = new MyLocationData.Builder();
        LatLng a = new LatLng(location.getLatitude(),location.getLongitude());
        LatLng b=GCJ02toBD09LL(a);
        builder.latitude(b.latitude);
        builder.longitude(b.longitude);
        MyLocationData data = builder.build();
        if (isFirstLocate){
            LatLng ll= new LatLng(b.latitude,b.longitude);
            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
            map.animateMapStatus(update);
            update = MapStatusUpdateFactory.zoomTo(17f);
            map.animateMapStatus(update);
            isFirstLocate = false;
        }

        map.setMyLocationData(data);

    }

    private  void reshow(final int a){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(com.example.hint.map.this," "+a,Toast.LENGTH_SHORT);
            }
        });
    }

    private void requestLocation() {
        initLocation();
        mLocation.start();
    }
    private void initLocation(){
        LocationClientOption option= new LocationClientOption();
        option.setScanSpan(5000);
        option.setCoorType("bd0911");
        mLocation.setLocOption(option);
    }
    @Override
    protected  void  onResume() {

        super.onResume();
        mapView.onResume();
    }
    @Override
    protected void onPause() {

        super.onPause();
        mapView.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocation.stop();
        mapView.onDestroy();
        map.setMyLocationEnabled(false);
    }


    public void onRequestPermissionResult(int requestCode, String[] permissions, int[] grantresults) {
        switch (requestCode) {
            case 1:
                if (grantresults.length > 0) {
                    for (int result : grantresults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(com.example.hint.map.this, "Lack of permission", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast.makeText(this, "Unknown error", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }
    public class MylocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(final BDLocation bdLocation) {
            latitude=bdLocation.getLatitude();
            longitude=bdLocation.getLongitude();
            mbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(latitude>30.488669&&latitude<30.490487&&longitude>114.38947054&&longitude<114.39156146){
                        Toast.makeText(com.example.hint.map.this,"签到成功",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(com.example.hint.map.this,"签到失败",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            if(bdLocation.getLocType() == BDLocation.TypeGpsLocation||bdLocation.getLocType()== BDLocation.TypeNetWorkLocation){
                navigateTo(bdLocation);
            }

        }

        public void onConnetcHotSpotMessage(String s,int i){
        }
    }
    public static LatLng GCJ02toBD09LL(LatLng sourceLatLng) {
        CoordinateConverter converter  = new CoordinateConverter();
        converter.from(CoordinateConverter.CoordType.COMMON);
        converter.coord(sourceLatLng);
        return converter.convert();
    }
}

