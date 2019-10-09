package com.example.notrashapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void executaPost(View view){
            TextView txtID = findViewById(R.id.textQR);
            TextView txtPeso = findViewById(R.id.txtPeso);
            TextView txtTipo = findViewById(R.id.txtTipo);
            TextView txtMock = findViewById(R.id.textMock);
            String url = "https://reqres.in/api/users/";
            String parameter ="{"+
            "\"id\":\""+txtID.getText()+ "\","+
            "\"peso\":\""+txtPeso.getText()+"\","+
            "\"tipo\":\""+txtTipo.getText()+"\"}";
            txtMock.setText(parameter);
            TextView txtMensagem = findViewById(R.id.textMock);
            new Poster(txtMensagem).execute(url,parameter);

        }

}
