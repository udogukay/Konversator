package maximus.galahadius.konversator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String worrd = "nothin' here";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void generate(View view) {
        //random sentence generator

        String[] array = getResources().getStringArray(R.array.convo_start);
        String randomStr = array[new Random().nextInt(array.length)];
        worrd = randomStr;
        TextView txtview = (TextView) findViewById(R.id.textwindow);
        txtview.setText(worrd);
    }
    public void txtcopy(View view){

        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Hey, ", worrd);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, "Text Copied to clipboard", Toast.LENGTH_SHORT).show();
    }
    public void txtshare(View view){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, worrd);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

}
