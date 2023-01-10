package id.ac.poliban.mi.maskah.hellotoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private int nCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvMessage = findViewById(R.id.tv_message);
        Button btToast = findViewById(R.id.button_toast);
        Button btCount = findViewById(R.id.button_count);

        if(savedInstanceState != null) {
            nCount = savedInstanceState.getInt( "nCount");
            tvMessage.setText(String.valueOf(nCount));
        }

        btToast.setOnClickListener(view ->{
            nCount = 0;
            tvMessage.setText(String.valueOf(nCount));
            nCount = savedInstanceState.getInt("nCount");
            tvMessage.setText(String.valueOf(nCount));
        });
    }

   @Override
           protected void onSaveInstanceState (@NonNull Bundle outState){
       super.onSaveInstanceState(outState);
       outState.putInt("nCount", nCount);

        }
}