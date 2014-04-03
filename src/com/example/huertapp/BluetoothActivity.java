package com.example.huertapp;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BluetoothActivity extends Activity {
	private BluetoothAdapter  BA;
	private ListView list_bt;
	private Set<BluetoothDevice>pairedDevices;
	private  ArrayAdapter<String> btArrayAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_list_bluetooth);
		  super.onCreate(savedInstanceState);
		  BA= BluetoothAdapter.getDefaultAdapter();
			 list_bt= (ListView)findViewById(R.id.ListBT);

		 /* ArrayAdapter<String> */
		  btArrayAdapter = new ArrayAdapter<String>(this,
		             android.R.layout.simple_list_item_1);
		  
		  
		  Set<BluetoothDevice> pairedDevices = BA.getBondedDevices();
		  Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
	         startActivityForResult(turnOn, 0);

		  if (pairedDevices.size() > 0) {
		      for (BluetoothDevice device : pairedDevices) {
		       String deviceBTName = device.getName();
		       /*String deviceBTMajorClass 
		        = getBTMajorDeviceClass(device
		          .getBluetoothClass()
		          .getMajorDeviceClass());*/
		       btArrayAdapter.add(deviceBTName );
		      }
		  }
		  list_bt.setAdapter(btArrayAdapter);
		  
		 }
		 
		/* private String getBTMajorDeviceClass(int major){
		  switch(major){ 
		  case BluetoothClass.Device.Major.AUDIO_VIDEO:
		   return "AUDIO_VIDEO";
		  case BluetoothClass.Device.Major.COMPUTER:
		   return "COMPUTER";
		  case BluetoothClass.Device.Major.HEALTH:
		   return "HEALTH";
		  case BluetoothClass.Device.Major.IMAGING:
		   return "IMAGING"; 
		  case BluetoothClass.Device.Major.MISC:
		   return "MISC";
		  case BluetoothClass.Device.Major.NETWORKING:
		   return "NETWORKING"; 
		  case BluetoothClass.Device.Major.PERIPHERAL:
		   return "PERIPHERAL";
		  case BluetoothClass.Device.Major.PHONE:
		   return "PHONE";
		  case BluetoothClass.Device.Major.TOY:
		   return "TOY";
		  case BluetoothClass.Device.Major.UNCATEGORIZED:
		   return "UNCATEGORIZED";
		  case BluetoothClass.Device.Major.WEARABLE:
		   return "AUDIO_VIDEO";
		  default: return "unknown!";
		  }
		 }

		 @Override
		 protected void onListItemClick(ListView l, View v, int position, long id) {
		  // TODO Auto-generated method stub
		  super.onListItemClick(l, v, position, id);
		  
		     Intent intent = new Intent();
		     setResult(RESULT_OK, intent);
		     finish();
		 }
		*/
}
