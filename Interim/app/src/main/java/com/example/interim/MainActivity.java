package com.example.interim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.Manifest;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements LocationListener{

    private Geocoder geocoder;
    private  LocationListener locationListener;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnConx = findViewById(R.id.conx);
        btnConx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Connexion.class);
                startActivity(intent);
            }
        });

        Button btnInscription = findViewById(R.id.inscription) ;
        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Role.class);
                startActivity(intent);
            }
        });


        locationManager = (LocationManager) getSystemService(this.LOCATION_SERVICE);
        geocoder = new Geocoder(this, Locale.getDefault());

        Button btnAnonyme = findViewById(R.id.anonyme);
        btnAnonyme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });

        Button btnAide=findViewById(R.id.xxx);
        btnAide.setOnClickListener(View->{
            Intent intent=new Intent(this,AIdeCv.class);
            startActivity(intent);

        });

    }

        private void showAlertDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Location Permission");
            builder.setMessage("Do you want to get your location?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //vérifier autorisation
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // Demande à l'utilisateur l'autorisation d'accéder à la localisation
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    } else {
                        // Démarre la mise à jour de la position
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,MainActivity.this );
                    }
                }
            });
            builder.setNegativeButton("No", null);
            builder.show();
        }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
                }
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude =location.getLatitude();
        double longitude=location.getLongitude();
        String message = "Latitude : " + latitude + "\nLongitude : " + longitude;
        try {
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                String cityName = address.getLocality();
                String loc = "Ville : "+cityName+"\nPays : "+address.getCountryName()+"\nCode postal : "+address.getPostalCode()+"\n "+message;
                Intent intent = new Intent(MainActivity.this,AccueilAnonyme.class);
                intent.putExtra("ville",cityName);
                intent.putExtra("pays",address.getCountryName());
                startActivity(intent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onProviderDisabled(String provider) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
    }

}