package kr.phps.vps.miraclehwan.privateseller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText id = (EditText) findViewById(R.id.login_id);
        final EditText password = (EditText) findViewById(R.id.login_password);
        Button B_Login = (Button) findViewById(R.id.login_button);
        Button B_Join = (Button) findViewById(R.id.join_button);

        B_Join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent M_Join = new Intent(Login.this, Join.class);
                startActivity(M_Join);
            }
        });

        B_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id.length()>0 && password.length()>0){
                    Login("http://miraclehwan.vps.phps.kr/Private_Seller/Login.php", id.getText().toString(), password.getText().toString());
                }else if(id.length()==0){
                    Toast.makeText(Login.this, "아이디를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }else if(password.length()==0){
                    Toast.makeText(Login.this, "패스워드를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Login(String uri, String id, String password){
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if(Boolean.parseBoolean(s)){
                    Toast.makeText(Login.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                    Intent move_home = new Intent(Login.this, Home.class);
                    startActivity(move_home);

                }else{
                    Toast.makeText(Login.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];
                String id = params[1];
                String password = params[2];


                try{

                    URL url = new URL(uri);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
                    data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

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
        getDataJSON.execute(uri, id, password);

    }

}
