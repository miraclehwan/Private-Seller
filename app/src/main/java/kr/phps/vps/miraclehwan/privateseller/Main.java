package kr.phps.vps.miraclehwan.privateseller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    EditText seller_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seller_name = (EditText) findViewById(R.id.main_name_edittext);

        seller_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(seller_name.length()>=10){
                    Toast.makeText(Main.this, "최대 10자까지 입력 가능합니다.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_next:
                if(seller_name.length()==0){
                    Toast.makeText(this, "상호명을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }else{
                    Intent Gohome = new Intent(Main.this, Home.class);
                    startActivity(Gohome);
                    finish();
                }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
