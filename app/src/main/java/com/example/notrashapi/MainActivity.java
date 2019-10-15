package com.example.notrashapi;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int MY_CAMERA_REQUEST_CODE = 100;
    public static final int CAMERA_PIC_REQUEST = 1137;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadImg();


        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);
        }
    }

    public void loadImg(){
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.logo);
    }

  /*  public void chamaCamera(View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, CAMERA_PIC_REQUEST);
    }*/
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
            //new Poster(txtMensagem).execute(url,parameter);

        }

        public void chamaCamera(View view){

            try {

                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // "PRODUCT_MODE for bar codes

                startActivityForResult(intent, 0);

            } catch (Exception e) {

                Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
                Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
                startActivity(marketIntent);

            }
        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView txtID = findViewById(R.id.textQR);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {

            if (resultCode == RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
                txtID.setText(contents);            }
            if(resultCode == RESULT_CANCELED){
                //handle cancel
            }
        }
    }
}
