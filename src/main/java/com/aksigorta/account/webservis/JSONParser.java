package com.aksigorta.account.webservis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

@SuppressWarnings("deprecation")
public class JSONParser {
  static InputStream is = null;
  static JSONObject jObj = null;
  static String json = "";
  // constructor
  public JSONParser() {
  }
  public static String getJSONFromUrl(String url) {     
    // Making HTTP request
    try {
      // defaultHttpClient
      @SuppressWarnings("resource")
	  DefaultHttpClient httpClient = new DefaultHttpClient();
      HttpGet httpPost = new HttpGet(url);
      
      HttpResponse httpResponse = httpClient.execute(httpPost);
      HttpEntity httpEntity = httpResponse.getEntity();
      is = httpEntity.getContent();
    } catch (UnsupportedEncodingException e) {

      e.printStackTrace();
    } catch (ClientProtocolException e) {

      e.printStackTrace();
    } catch (IOException e) {

      e.printStackTrace();
    }
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(
          is, "UTF-8"), 8);
      StringBuilder sb = new StringBuilder();
      String line = null;
      while ((line = reader.readLine()) != null) {
        sb.append(line + "\n");
      }
      is.close();
      json = sb.toString();

    } catch (Exception e) {

    }
    // JSON'� string olarak d�nd�r�yoruz.
    return json;
  }
}