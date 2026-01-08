package com.s.loginapp;

//  AppCompatActivity को Import किया ताकि हम Activity बना सकें
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetPasswordActivity extends AppCompatActivity {

    //  EditText और Button के लिए variables बनाए
    EditText edtUsername;
    Button btnResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  इस Activity के लिए layout set किया (activity_forget_password.xml)
        setContentView(R.layout.activity_forget_password);

        //  XML के EditText और Button को Java कोड से जोड़ा
        edtUsername = findViewById(R.id.edtUsername);
        btnResetPassword = findViewById(R.id.btnResetPassword);

        //  Reset Password बटन पर क्लिक करने पर क्या होगा — ये बताया
        btnResetPassword.setOnClickListener(v -> {

            //  यूज़रनेम का टेक्स्ट लिया और trim() से खाली spaces हटाए
            String user = edtUsername.getText().toString().trim();

            //  अगर यूज़रनेम खाली है तो Toast से message दिखाया
            if (user.isEmpty()) {
                Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
                return; // आगे का कोड नहीं चलेगा
            }

            //  अगर यूज़रनेम भरा है तो Success message दिखाया
            Toast.makeText(this, "Password reset link sent to " + user, Toast.LENGTH_SHORT).show();

            //  finish() method से Activity बंद की और वापस Login Page पर लौटे
            finish();
        });
    }
}