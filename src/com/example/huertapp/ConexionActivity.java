package com.example.huertapp;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;


public class ConexionActivity extends ActionBarActivity {
	private Button btn_bluetooth;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conexion); 
        
        btn_bluetooth = (Button) findViewById( R.id.btn_connect );
    
    
    btn_bluetooth.setOnClickListener(new View.OnClickListener() {

    	
    	  public void onClick(View v) {
    	    
    		  			Intent register_intent = new Intent( getApplicationContext(), BluetoothActivity.class );
                        startActivity( register_intent );
                        finish();
                       
    	  }
     
    	});
}
}
    
       

           
    

