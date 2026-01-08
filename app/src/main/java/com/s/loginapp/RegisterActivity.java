package com.s.loginapp;

//  Activity बनाने के लिए जरूरी लाइब्रेरीज़ Import कीं
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    //  EditText और Button के लिए वेरिएबल बनाए
    EditText edtNewUsername, edtNewPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  इस Activity का Layout XML से जोड़ा
        setContentView(R.layout.activity_register);

        //  XML में दिए गए EditText और Button को Java कोड से लिंक किया
        edtNewUsername = findViewById(R.id.edtNewUsername);
        edtNewPassword = findViewById(R.id.edtNewPassword);
        btnRegister = findViewById(R.id.btnRegister);

        //  Register बटन पर क्लिक करने पर क्या होगा — यह बताया
        btnRegister.setOnClickListener(v -> {

            //  EditText से यूज़रनेम और पासवर्ड लिया और trim() से spaces हटाए
            String user = edtNewUsername.getText().toString().trim();
            String pass = edtNewPassword.getText().toString().trim();

            //  अगर Username खाली है तो Toast से मैसेज दिखाया
            if (user.isEmpty()) {
                Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
                return; // आगे का कोड नहीं चलेगा
            }

            //  अगर Password खाली है तो Toast से मैसेज दिखाया
            if (pass.isEmpty()) {
                Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
                return;
            }

            //  अगर दोनों भरे हैं तो Success मैसेज दिखाया
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();

            //  finish() से Activity बंद की और वापस Login Page पर लौट गए
            finish();
        });
    }
}