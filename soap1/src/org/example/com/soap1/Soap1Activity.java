package org.example.com.soap1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;


import android.view.View;
import android.view.View.OnClickListener;

public class Soap1Activity extends Activity implements  OnClickListener {
    /** Called when the activity is first created. */
	private static final String TAG = "SOAP1";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Log.d(TAG, "Start!");
		
		View startButton= findViewById (R.id.button1);
		startButton.setOnClickListener(this);
		View exitButton= findViewById (R.id.button2);
		exitButton.setOnClickListener(this);
    }
    
    public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Log.d(TAG, "Start Button");

		    DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://p-xr.com/xml");
            HttpResponse httpResponse;
            HttpEntity httpEntity;
			try {
				httpResponse = httpClient.execute(httpPost);
	            httpEntity = httpResponse.getEntity();
				try {
					String line = EntityUtils.toString(httpEntity);
		            Log.d(TAG, "result:"+line);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClientProtocolException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}



			/*
	        HttpClient httpClient = new DefaultHttpClient();
	        HttpContext localContext = new BasicHttpContext();
	        HttpGet httpGet = new HttpGet("http://www.yandex.ru/");
	        try {
				HttpResponse response = httpClient.execute(httpGet, localContext);
				
				Log.d(TAG, response.toString());
				Log.d(TAG, response.getStatusLine().toString() );
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			*/

			/*
	        HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            try {
				request.setURI(new URI("http://yandex.ru/"));
			} catch (URISyntaxException e1) {
				Log.d(TAG, "URI Error");
				e1.printStackTrace();
			}            	       
	        try {
	        	HttpResponse response = client.execute(request);
				Log.d(TAG, "Result:"+response.toString());
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			*/
			
//			Intent i = new Intent(this, About.class);
//			startActivity(i);
			break;
		case R.id.button2:
			Log.d(TAG, "Exit Button");
			finish();
			break;
		// More buttons go here (if any) ...
		}
	}
	
    /*
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();
        HttpGet httpGet = new HttpGet("http://www.yandex.ru/");
        try {
			HttpResponse response = httpClient.execute(httpGet, localContext);
			
			Log.d(TAG, response.toString());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/    
}