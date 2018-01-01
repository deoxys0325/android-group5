package com.example.deoxys.schooltutor;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,AdapterView.OnItemSelectedListener,DialogInterface.OnCancelListener{

    private GoogleMap mMap, VendingMachine, Restroom, Restaurant;
    Spinner spnMapType, spinner2;
    private Button button;
    String[] mapType = { "街道圖", "衛星圖", "衛星圖+街道圖" };
    String[] Tutor = { "", "洗手間", "販賣機", "餐廳" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        int errorCode= GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if(errorCode!= ConnectionResult.SUCCESS)
            GooglePlayServicesUtil.showErrorDialogFragment(errorCode,this,111,this);
        else {
            spnMapType = (Spinner) findViewById(R.id.spinner1);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mapType);
            spnMapType.setAdapter(adapter);
            spnMapType.setOnItemSelectedListener(this);
        }

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Tutor);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(25.150953, 121.780101), 17));
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        VendingMachine = googleMap; Restroom = googleMap; Restaurant = googleMap;
        LatLng sydney = new LatLng(25.150953, 121.780101);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(25.150953, 121.780101), 17));
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId()==(R.id.spinner1)) {
            switch (position) {
                case 0:/* 一般街道模式 */
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    break;
                case 1:/* 衛星模式 */
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    break;
                case 2:/* 街道衛星混和模式 */
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    break;
            }
        }else if(parent.getId()==R.id.spinner2){ //mark不同設施的位置


            switch (position) {
                case 0:/*  */
                    Restroom.clear();
                    VendingMachine.clear();
                    Restaurant.clear();
                    break;
                case 1:/* 洗手間 */
                    VendingMachine.clear();
                    Restaurant.clear();
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.149663, 121.777308)).title("育樂館一樓男、女廁"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.149010, 121.779060)).title("游泳池一樓更衣室"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.150348, 121.775350)).title("圖書館各樓男、女廁"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.149250, 121.777756)).title("延平技術大樓各樓男、女廁"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.150581, 121.780882)).title("工學院各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.149561, 121.773076)).title("綜合一館(一至四樓)各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.149202, 121.774448)).title("海事大樓各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.149778, 121.775799)).title("行政大樓各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.150243, 121.776286)).title("行政大樓各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.149623, 121.772095)).title("漁學館各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.150363, 121.772528)).title("海洋系館各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.150159, 121.780062)).title("學生活動中心各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.150742, 121.773020)).title("食科系工程館各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.150558, 121.774965)).title("綜合二館各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.150591, 121.780521)).title("電機系館各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.150536, 121.781136)).title("系統工程學系各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.150024, 121.781818)).title("河工系館各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.150939, 121.780114)).title("資工系、電機二館各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.150147, 121.782743)).title("河工二館各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.149474, 121.779050)).title("海空大樓(一至七樓)各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.149843, 121.775048)).title("人文大樓(地下一層、地上七層)各樓層男、女廁所(含浴室)"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.149546, 121.778430)).title("航管系館各樓層男、女廁所"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.148714, 121.773829)).title("女一舍各樓層女廁"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.148415, 121.775451)).title("男一舍各樓層男廁"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.148639, 121.778702)).title("男二舍各樓層男廁"));
                    Restroom.addMarker(new MarkerOptions().position(new LatLng(25.148762, 121.779163)).title("男三女二舍"));
                    break;
                case 2:/*販賣機 */
                    Restroom.clear();
                    Restaurant.clear();
                    VendingMachine.addMarker(new MarkerOptions().position(new LatLng(25.150922, 121.780127)).title("電機二館 1 樓穿堂"));
                    VendingMachine.addMarker(new MarkerOptions().position(new LatLng(25.150147, 121.782743)).title("河工二館 1 樓穿堂"));
                    VendingMachine.addMarker(new MarkerOptions().position(new LatLng(25.149423, 121.776958)).title("育樂館左側門口"));
                    VendingMachine.addMarker(new MarkerOptions().position(new LatLng(25.149739, 121.777200)).title("育樂館右側門口"));
                    VendingMachine.addMarker(new MarkerOptions().position(new LatLng(25.150599, 121.772541)).title("生命科學院 2、4樓"));
                    VendingMachine.addMarker(new MarkerOptions().position(new LatLng(25.149660, 121.772915)).title("綜合一館門口"));
                    VendingMachine.addMarker(new MarkerOptions().position(new LatLng(25.150355, 121.781497)).title("河工一館 1 樓"));
                    VendingMachine.addMarker(new MarkerOptions().position(new LatLng(25.150554, 121.774969)).title("綜合二館 1 樓"));
                    VendingMachine.addMarker(new MarkerOptions().position(new LatLng(25.148426, 121.775412)).title("男一舍 2樓 239、3 樓 339 房前"));
                    VendingMachine.addMarker(new MarkerOptions().position(new LatLng(25.150635, 121.780846)).title("工學院地下室大廳"));
                    break;
                case 3:/*餐廳*/
                    Restroom.clear();
                    VendingMachine.clear();
                    Restaurant.addMarker(new MarkerOptions().position(new LatLng(25.148831, 121.775233)).title("第一餐廳"));
                    Restaurant.addMarker(new MarkerOptions().position(new LatLng(25.148452, 121.779097)).title("第二餐廳"));
                    Restaurant.addMarker(new MarkerOptions().position(new LatLng(25.150646, 121.780844)).title("工學院餐廳"));
                    Restaurant.addMarker(new MarkerOptions().position(new LatLng(25.150214, 121.776864)).title("海音咖啡"));
                    Restaurant.addMarker(new MarkerOptions().position(new LatLng(25.147746, 121.779260)).title("雅廬韓式料理"));
                    Restaurant.addMarker(new MarkerOptions().position(new LatLng(25.149125, 121.779645)).title("廢墟披薩"));
                    Restaurant.addMarker(new MarkerOptions().position(new LatLng(25.149809, 121.775202)).title("薈萃坊 Elitecafe"));
                    Restaurant.addMarker(new MarkerOptions().position(new LatLng(25.148970, 121.775144)).title("全家便利商店"));
                    Restaurant.addMarker(new MarkerOptions().position(new LatLng(25.148861, 121.778403)).title("全家便利商店"));
                    Restaurant.addMarker(new MarkerOptions().position(new LatLng(25.150282, 121.779999)).title("OK便利商店"));
                    Restaurant.addMarker(new MarkerOptions().position(new LatLng(25.150252, 121.780132)).title("貴族世家 海洋大學店"));
                    break;
            }
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        finish(); /* 將視窗關閉*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
