package android.efficientprogrammer.com.threads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.R.attr.bitmap;

public class MainActivity extends AppCompatActivity {
Button load,other;
    private Bitmap bit;
    ImageView imview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load=(Button)findViewById(R.id.load);
        other=(Button)findViewById(R.id.other);
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"I am responding",Toast.LENGTH_LONG).show();
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImage();
            }
        });

    }

    private void loadImage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                bit= BitmapFactory.decodeResource(getResources(),R.drawable.image);
                imview=(ImageView)findViewById(R.id.imview);
                imview.post(new Runnable() {
                    @Override
                    public void run() {
                        imview.setImageBitmap(bit);
                    }
                });

            }
        }).start();

    }
}
