package com.s.loginapp;

//  जरूरी Android classes import की गईं
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //  UI में इस्तेमाल होने वाले View के लिए variables बनाए
    EditText edtUsername, edtPassword;
    Button btnLogin;
    TextView txtRegister, txtForget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  XML layout को इस Activity से जोड़ा
        setContentView(R.layout.activity_main);

        //  XML के Views को Java कोड से जोड़ा
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtRegister = findViewById(R.id.txtRegister);
        txtForget = findViewById(R.id.txtForget);

        //  Login बटन पर क्लिक करने का कोड
        btnLogin.setOnClickListener(v -> {
            //  यूज़रनेम और पासवर्ड इनपुट से प्राप्त किए
            String user = edtUsername.getText().toString().trim();
            String pass = edtPassword.getText().toString().trim();

            //  अगर Username खाली है तो मैसेज दिखाओ
            if (user.isEmpty()) {
                Toast.makeText(this, "Please enter Username", Toast.LENGTH_SHORT).show();
                return;
            }

            //  अगर Password खाली है तो मैसेज दिखाओ
            if (pass.isEmpty()) {
                Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
                return;
            }

            //  Login सफल होने पर HomeActivity पर जाने के लिए Intent बनाया
            Intent i = new Intent(MainActivity.this, HomeActivity.class);

            //  Username और Password को अगले Activity में भेजा
            i.putExtra("username", user);
            i.putExtra("password", pass);

            //  अगला Activity शुरू किया (HomeActivity)
            startActivity(i);
        });

        //  Register पर क्लिक करने का कोड
        txtRegister.setOnClickListener(v -> {
            //  RegisterActivity खोलने के लिए Intent बनाया
            Intent i = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(i); //  Register पेज ओपन हुआ
        });

        //  Forget Password प
        txtForget.setOnClickListener(v -> {
            //  ForgetPasswordActivity खोलने के लिए Intent बनाया
            Intent i = new Intent(MainActivity.this, ForgetPasswordActivity.class);
            startActivity(i); //  Forget Password पेज ओपन हुआ
        });
    }

    //  ही नवी method आहे जी onCreate() नंतर लिहायची आहे
    @Override
    protected void onResume() {
        super.onResume();
        //  जेव्हा activity परत स्क्रीनवर येते तेव्हा username आणि password साफ करा
        edtUsername.setText("");
        edtPassword.setText("");
    }
}
