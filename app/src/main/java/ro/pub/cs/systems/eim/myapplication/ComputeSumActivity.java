package ro.pub.cs.systems.eim.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ComputeSumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String terms = intent.getStringExtra("terms");
        if (!TextUtils.isEmpty(terms)) {
            String[] termArray = terms.split(" \\+ ");
            int sum = 0;
            for (String term : termArray) {
                sum += Integer.parseInt(term);
            }
            Toast.makeText(this, "Sum: " + sum, Toast.LENGTH_LONG).show();
        }

        finish();
    }
}