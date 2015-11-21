package com.anselmopfeifer.htapp.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.camera.CropImageIntentBuilder;
import com.anselmopfeifer.htapp.R;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Anselmo on 24/10/2015.
 */
public class UserImageActivity extends AppCompatActivity{
    private static final int CAMERA_REQUEST = 123;
    private static final  int CROP_REQUEST = 456;
    Uri imageUri;

    @Bind(R.id.lis_users_image)
    ImageView userImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.user_image)
    public void changeImage(){
        File image = new File(getExternalCacheDir(), "teste");
        imageUri = Uri.fromFile(image);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        File croppedImage = new File(getFilesDir(), "testeCropped.jpg");

        if(requestCode == 123 && requestCode == RESULT_OK){
            Uri croppedImageUri = Uri.fromFile(croppedImage);
            CropImageIntentBuilder crop = new CropImageIntentBuilder(200, 200, croppedImageUri);
            crop.setOutlineCircleColor(0xFF03A9F4);
            crop.setSourceImage(imageUri);
            startActivityForResult(crop.getIntent(UserImageActivity.this), CROP_REQUEST);

        }else if(requestCode == CROP_REQUEST && resultCode == RESULT_OK){
            userImage.setImageBitmap(BitmapFactory.decodeFile(croppedImage.getAbsolutePath()));

        }
        else{
            Toast.makeText(this, "Imagem não carregada", Toast.LENGTH_SHORT).show();
        }
    }
}





