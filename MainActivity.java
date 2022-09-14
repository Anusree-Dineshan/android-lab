package com.example.sharedpreference;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText Name,Age,Phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.N1);
        Age=(EditText)findViewById(R.id.A1);
        Phone=(EditText)findViewById(R.id.P1);
    }
    public void onResume() {
        super.onResume();
        SharedPreferences sh=getSharedPreferences("sp", MODE_PRIVATE);
        String s1 = sh.getString("Name", "");

        int ph = sh.getInt("Phone", 0);
        int a = sh.getInt("Age",0 );
        Name.setText(s1);

        Phone.setText(String.valueOf(ph));
        Age.setText(String.valueOf(a));
    }
    public void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("sp",
                MODE_PRIVATE);
        SharedPreferences.Editor sp = sharedPreferences.edit();
        sp.putString("name", Name.getText().toString());

        sp.putInt("Age", Integer.parseInt(Age.getText().toString()));
        sp.putInt("Phone", Integer.parseInt(Phone.getText().toString()));
        sp.commit();
        sp.apply();
    }
}