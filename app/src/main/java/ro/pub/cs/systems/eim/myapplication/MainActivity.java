package ro.pub.cs.systems.eim.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText nextTermEditText = findViewById(R.id.next_term);
        EditText allTermsEditText = findViewById(R.id.all_terms);
        Button addButton = findViewById(R.id.add_button);
        Button computeButton = findViewById(R.id.compute_button);

        addButton.setOnClickListener(v -> {
            String nextTerm = nextTermEditText.getText().toString();
            if (TextUtils.isDigitsOnly(nextTerm)) {
                String allTerms = allTermsEditText.getText().toString();
                if (!TextUtils.isEmpty(allTerms)) {
                    allTerms += " + ";
                }
                allTerms += nextTerm;
                allTermsEditText.setText(allTerms);
            }
        });

        computeButton.setOnClickListener(v -> {
            String allTerms = allTermsEditText.getText().toString();
            Intent intent = new Intent("com.example.SecondaryApplication.ACTION_COMPUTE_SUM");
            intent.putExtra("terms", allTerms);
            startActivity(intent);
        });

    }
}