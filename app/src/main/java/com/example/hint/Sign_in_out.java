//package com.example.hint;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//
//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.location.Location;
//import android.os.Bundle;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.baidu.location.BDLocation;
//import com.baidu.location.BDLocationListener;
//import com.baidu.location.LocationClient;
//import com.baidu.mapapi.map.BaiduMap;
//import com.baidu.mapapi.map.MapStatusUpdate;
//import com.baidu.mapapi.map.MapStatusUpdateFactory;
//import com.baidu.mapapi.map.MapView;
//import com.baidu.mapapi.map.MyLocationData;
//import com.baidu.mapapi.model.LatLng;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Sign_in_out extends AppCompatActivity {
//    public LocationClient mLocationClient;
//    private TextView positionText;
//    private MapView mapView;
//    private BaiduMap map;
//    private boolean isFirstLocate = true;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mLocationClient=new LocationClient(getApplicationContext());
//        mLocationClient.registerLocationListener(new MyLocationListener());
//        setContentView(R.layout.activity_sign_in_out);
//        positionText=findViewById(R.id.position_text_view);
//        List<String> permissionList=new ArrayList<>();
//        if(ContextCompat.checkSelfPermission(Sign_in_out.this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
//            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
//        }
//        if (ContextCompat.checkSelfPermission(Sign_in_out.this,Manifest.permission.READ_PHONE_STATE)!=PackageManager.PERMISSION_GRANTED){
//            permissionList.add(Manifest.permission.READ_PHONE_STATE);
//        }
//        if (ContextCompat.checkSelfPermission(Sign_in_out.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
//            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        }
//        if (!permissionList.isEmpty()){
//            String [] permissions=permissionList.toArray(new String[permissionList.size()]);
//            ActivityCompat.requestPermissions(Sign_in_out.this,permissions,1);
//        }else {
//            requestLocations();
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode){
//            case 1:
//                if (grantResults.length>0){
//                    for(int result:grantResults){
//                        if(result!=PackageManager.PERMISSION_GRANTED){
//                            Toast.makeText(this,"必须同意所有权限",Toast.LENGTH_SHORT).show();
//                            finish();
//                            return;
//                        }
//                    }
//                    requestLocations();
//                }else{
//                    Toast.makeText(this,"未知错误",Toast.LENGTH_SHORT).show();
//                    finish();
//                }
//                break;
//            default:
//        }
//    }
//
//    private void navigateTo(BDLocation location)  {
//        if (isFirstLocate){
//            LatLng ll= new LatLng(location.getLatitude(),location.getLongitude());
//            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
//            map.animateMapStatus(update);
//            update = MapStatusUpdateFactory.zoomTo(17f);
//            map.animateMapStatus(update);
//            isFirstLocate = false;
//        }
//        MyLocationData.Builder builder = new MyLocationData.Builder();
//        LatLng a = new LatLng(location.getLatitude(),location.getLongitude());
//        LatLng b=GCJ02toBD09LL(a);
//        builder.latitude(b.latitude);
//        builder.longitude(b.longitude);
//        MyLocationData data = builder.build();
//        map.setMyLocationData(data);
//
//    }
//
//
//
////    private static LatLng GCJ02toBD09LL(LatLng sourceLatLng) {
////        CoordinateConverter converter  = new CoordinateConverter();
////        converter.from(CoordinateConverter.CoordType.COMMON);
////        converter.coord(sourceLatLng);
////        return converter.convert();
////    }
//
//    private void requestLocations() {
//        mLocationClient.start();
//    }
//
//    public class MyLocationListener implements BDLocationListener{
//
//        @Override
//        public void onReceiveLocation(final BDLocation bdLocation) {
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    StringBuilder currentPosition=new StringBuilder();
//                    currentPosition.append("经度：").append(bdLocation.getLatitude()).append("\n");
//                    currentPosition.append("纬度：").append(bdLocation.getLongitude()).append("\n");
//                    currentPosition.append("定位方式：");
//                    if(bdLocation.getLocType()==BDLocation.TypeGpsLocation){
//                        currentPosition.append("GPS");
//                    }else if(bdLocation.getLocType()==BDLocation.TypeNetWorkLocation){
//                        currentPosition.append("网络");
//                    }
//                    positionText.setText(currentPosition);
//                }
//            });
//        }
//    }
//}
