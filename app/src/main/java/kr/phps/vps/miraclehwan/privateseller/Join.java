package kr.phps.vps.miraclehwan.privateseller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Daehwan Kim on 2017-02-28.
 */

public class Join extends AppCompatActivity {

    Boolean B_id = false;
    Boolean B_name = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        final EditText id = (EditText) findViewById(R.id.join_id);
        final EditText password = (EditText) findViewById(R.id.join_password);
        final EditText passwordcheck = (EditText) findViewById(R.id.join_passwordcheck);
        final EditText name = (EditText) findViewById(R.id.join_name);

        Button check_id = (Button) findViewById(R.id.join_check_id);
        Button check_name = (Button) findViewById(R.id.join_check_name);
        Button join = (Button) findViewById(R.id.join_join);

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(B_id && B_name && password.length() > 0 && password.getText().toString().equals(passwordcheck.getText().toString())){
                    Join("http://miraclehwan.vps.phps.kr/Private_Seller/Join.php", id.getText().toString(), password.getText().toString(), name.getText().toString());
                }else if(!B_id){
                    Toast.makeText(Join.this, "아이디를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }else if(!B_name){
                    Toast.makeText(Join.this, "닉네임을 확인해주세요.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Join.this, "패스워드를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                B_id = false;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                B_name = false;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        check_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id.length()>0){
                    CheckID("http://miraclehwan.vps.phps.kr/Private_Seller/Check_ID.php", id.getText().toString());
                }else{
                    Toast.makeText(Join.this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        check_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.length()>0){
                    CheckNAME("http://miraclehwan.vps.phps.kr/Private_Seller/Check_NAME.php", name.getText().toString());
                }else{
                    Toast.makeText(Join.this, "닉네임을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void CheckID(String uri, String id){
        class GetDataJSON extends AsyncTask<String, Void, String>{

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if(!Boolean.parseBoolean(s)){
                    B_id = true;
                    Toast.makeText(Join.this, "사용가능한 아이디 입니다.", Toast.LENGTH_SHORT).show();
                }else{
                    B_id = false;
                    Toast.makeText(Join.this, "중복된 아이디가 존재합니다.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];
                String id = params[1];

                try{

                    URL url = new URL(uri);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");

                    connection.setDoOutput(true);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());

                    outputStreamWriter.write(data);;
                    outputStreamWriter.flush();

                    StringBuilder stringBuilder = new StringBuilder();
                    BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    String json;
                    while((json = bufferedReader.readLine()) != null){
                        stringBuilder.append(json + "\n");
                    }


                    return stringBuilder.toString().trim();

                }catch (Exception e){
                    return null;
                }
            }
        }

        GetDataJSON getDataJSON = new GetDataJSON();
        getDataJSON.execute(uri, id);

    }

    public void CheckNAME(String uri, String name){
        class GetDataJSON extends AsyncTask<String, Void, String>{

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if(!Boolean.parseBoolean(s)){
                    B_name = true;
                    Toast.makeText(Join.this, "사용가능한 닉네임입니다.", Toast.LENGTH_SHORT).show();
                }else{
                    B_name = false;
                    Toast.makeText(Join.this, "중복된 닉네임이 존재합니다.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];
                String name = params[1];

                try{

                    URL url = new URL(uri);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");

                    connection.setDoOutput(true);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());

                    outputStreamWriter.write(data);;
                    outputStreamWriter.flush();

                    StringBuilder stringBuilder = new StringBuilder();
                    BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    String json;
                    while((json = bufferedReader.readLine()) != null){
                        stringBuilder.append(json + "\n");
                    }


                    return stringBuilder.toString().trim();

                }catch (Exception e){
                    return null;
                }
            }
        }

        GetDataJSON getDataJSON = new GetDataJSON();
        getDataJSON.execute(uri, name);

    }

    public void Join(String uri, String id, String password, String name){
        class GetDataJSON extends AsyncTask<String, Void, String>{

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if(Boolean.parseBoolean(s)){
                    Toast.makeText(Join.this, "가입완료", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Join.this, "가입실패", Toast.LENGTH_SHORT).show();
                }
                finish();
            }

            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];
                String id = params[1];
                String password = params[2];
                String name = params[3];


                try{

                    URL url = new URL(uri);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
                    data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                    data += "&" + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");

                    connection.setDoOutput(true);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream());

                    outputStreamWriter.write(data);;
                    outputStreamWriter.flush();

                    StringBuilder stringBuilder = new StringBuilder();
                    BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    String json;
                    while((json = bufferedReader.readLine()) != null){
                        stringBuilder.append(json + "\n");
                    }


                    return stringBuilder.toString().trim();

                }catch (Exception e){
                    return null;
                }
            }
        }

        GetDataJSON getDataJSON = new GetDataJSON();
        getDataJSON.execute(uri, id, password, name);

    }

}
