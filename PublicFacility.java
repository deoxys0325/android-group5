package com.example.deoxys.schooltutor;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PublicFacility extends FragmentActivity implements OnMapReadyCallback,AdapterView.OnItemSelectedListener,DialogInterface.OnCancelListener {

    private GoogleMap mMap, Building;
    Spinner spnMapType, spinner2;
    private Button button;
    String[] mapType = {"街道圖", "衛星圖", "衛星圖+街道圖"};
    String[] PublicFacility = {"", "系館", "大樓", "活動場所", "其他"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_facility);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        int errorCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (errorCode != ConnectionResult.SUCCESS)
            GooglePlayServicesUtil.showErrorDialogFragment(errorCode, this, 111, this);
        else {
            spnMapType = (Spinner) findViewById(R.id.spinner1);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mapType);
            spnMapType.setAdapter(adapter);
            spnMapType.setOnItemSelectedListener(this);

            Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
            ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, PublicFacility);
            spinner2.setAdapter(adapter2);
            spinner2.setOnItemSelectedListener(this);
        }

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(25.150953, 121.780101), 17));
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Building = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(25.150953, 121.780101);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(25.150953, 121.780101), 17));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == (R.id.spinner1)) {
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
        } else if (parent.getId() == R.id.spinner2) { //mark不同設施的位置


            switch (position) {
                case 0:/*  */
                    Building.clear();
                    break;
                case 1:/*系館*/
                    Building.clear();
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150024, 121.781817)).title("河海工程學系\n" + "海洋工程科技學士學位學程(系)"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150537, 121.781138)).title("系統工程暨造船學系系館"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150597, 121.780513)).title("電機工程學系"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150932, 121.780123)).title("資訊工程學系"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149537, 121.778417)).title("航運管理學系"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149508, 121.778874)).title("海洋觀光管理學士學位學程(系)\n" + "海洋法政學士學位學程(系)\n" + "海洋經營理學士學位學程(系)"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149263, 121.777748)).title("運輸科學系"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149280, 121.777694)).title("通訊與導航工程學系"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149297, 121.777727)).title("輪機工程學系"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149809, 121.777536)).title("商船學系"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150239, 121.776605)).title("機械與機電工程學系"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149884, 121.773318)).title("海洋環境資訊系"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149615, 121.772095)).title("環境生物與漁業科學學系"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150357, 121.772530)).title("水產養殖學系\n" + "生命科學暨生物科技學系" + "海洋生物科技學士學位學程(系)"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150739, 121.773018)).title("食品科學系"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149801, 121.775204)).title("海洋文創設計產業學位學程(系)"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150576, 121.775560)).title("光電與材料科技學士學位學程(系)"));

                    break;
                case 2:/*大樓*/
                    Building.clear();
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150149, 121.776186)).title("行政大樓"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150356, 121.772531)).title("國立台灣海洋大學 生命科學院"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149618, 121.772096)).title("國立臺灣海洋大學中正漁學館"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149618, 121.772911)).title("國立台灣海洋大學 綜合一館"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149371, 121.774578)).title("海事大樓"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149703, 121.778155)).title("沛華大樓"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149508, 121.778874)).title("海空大樓"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150585, 121.780799)).title("工學院館"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149242, 121.777751)).title("延平技術大樓"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149280, 121.775298)).title("綜合三館"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150554, 121.774962)).title("綜合二館"));

                    break;
                case 3:/*活動場所*/
                    Building.clear();
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150339, 121.775347)).title("國立臺灣海洋大學圖書館"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150605, 121.775811)).title("海洋大學郵局基隆7支局"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149775, 121.775803)).title("海洋廳\n" + "展示廳"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150024, 121.772881)).title("國立臺灣海洋大學露天排球場 & 網球場"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149148, 121.774920)).title("夢泉"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149786, 121.776643)).title("X型廣場"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149561, 121.777174)).title("育樂館"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150453, 121.778147)).title("海洋大學育樂館體育場"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149007, 121.779066)).title("游泳池"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150142, 121.780056)).title("海洋大學學生活動中心"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150167, 121.779107)).title("海大體育館"));

                    break;
                case 4:/*其他*/
                    Building.clear();
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150446, 121.775572)).title("五南文化廣場(海洋書坊)"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.149630, 121.772595)).title("龍崗生態園區 - 海洋大學"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.148705, 121.773842)).title("海大女一宿舍"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.148759, 121.774984)).title("海洋大學龍崗步道"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.148639, 121.778700)).title("男生第二宿舍"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.148647, 121.779199)).title("女生第二宿舍及男生第三宿舍"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.148611, 121.779219)).title("ATM"));
                    Building.addMarker(new MarkerOptions().position(new LatLng(25.150760, 121.772912)).title("ATM"));

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