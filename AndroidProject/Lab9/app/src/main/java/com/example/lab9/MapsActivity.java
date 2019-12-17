package com.example.lab9;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.location.Location;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;

//---------Resources-------
//image icon- https://housing.umn.edu/files/map-icon
//https://www.programcreek.com/java-api-examples/?class=android.location.Location&method=getLongitude
//https://medium.com/@droidbyme/get-current-location-using-fusedlocationproviderclient-in-android-cb7ebf5ab88e
//https://stackoverflow.com/questions/18486503/android-google-maps-api-v2-how-to-change-marker-icon
//https://stackoverflow.com/questions/19076124/android-map-marker-color

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker mCurrentLocationMarker;

    //location permission, can be any value >0
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1;
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
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

        // Add markers
        LatLng home = new LatLng(40.007086, -105.243695);
        mMap.addMarker(new MarkerOptions().position(home).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)).title("Current Home"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(home));

        LatLng childhoodhome = new LatLng(43.710175, 7.261953);
        mMap.addMarker(new MarkerOptions().position(childhoodhome).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).title("Childhood Home"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(childhoodhome));

        //set map type
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        checkLocationPermission();

    }
    /*
        We check from the user if we have permission to locate them
        We call this function in onMapReady
     */

    public void checkLocationPermission()
    {
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                new AlertDialog.Builder(this)
                        .setTitle(R.string.dialogTitle)
                        .setMessage(R.string.dialogMessage)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(MapsActivity.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        })
                        .create()
                        .show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
        else {
            mMap.setMyLocationEnabled(true);
            startLocationUpdates();
        }
    }
/*
    Notes from class:
    Location Request: Objects of the LocationRequest class are used to request
    location updates from the FusedLocationProviderClient. The FusedLocationProviderClient
    is one of the location APIs in Google Play services. It manages the underlying location tech
    such as analyzing GPS, Cellular, and Wi-Fi network location data in order to provide the highest
    accuracy data.
 */

    protected void startLocationUpdates() {

        LocationRequest mLocationRequest = new LocationRequest();

        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(500);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        LocationSettingsRequest locationSettingsRequest = builder.build();

        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
        settingsClient.checkLocationSettings(locationSettingsRequest);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mFusedLocationClient.requestLocationUpdates(mLocationRequest, new LocationCallback() {
                        @Override
                        public void onLocationResult(LocationResult locationResult) {
                            onLocationChanged(locationResult.getLastLocation());
                            System.out.println("Location result: "+locationResult.getLastLocation());

                        }
                    },
                    Looper.myLooper());
        }
    }

    /*
        Location Changes: We've set up our app to get regular location intervals but now we have to implement
        OnLocationChanged() which is called whenever the user locations changes and onLocationResult gets
        called.
     */

    public void onLocationChanged(Location location) {

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        System.out.println("Location Latitude: " + location.getLatitude());
        System.out.println("Location Longitude: " + location.getLongitude());

        if (mCurrentLocationMarker == null) {

            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title("Current Position");
            markerOptions.draggable(true);

            mCurrentLocationMarker = mMap.addMarker(markerOptions);

        } else{

            mCurrentLocationMarker.setPosition(latLng);
        }


        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
    }

    /*
        requestPermission() will then call onRequestPermissionsResult() and passes it the user's response
        and your request code.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission was granted
                    if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        mMap.setMyLocationEnabled(true);
                        startLocationUpdates();
                        Toast.makeText(this, "permission granted", Toast.LENGTH_LONG).show();
                    }
                } else { // Permission denied
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
            }

        }
    }


}
