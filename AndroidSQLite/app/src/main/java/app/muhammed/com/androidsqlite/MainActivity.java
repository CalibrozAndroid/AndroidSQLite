package app.muhammed.com.androidsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import app.muhammed.com.androidsqlite.models.UserModel;
import app.muhammed.com.androidsqlite.storage.UserRegistrationHandler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mNameEditText;
    private EditText mEmailEditText;
    private EditText mPhoneEditText;
    private EditText mPlaceEditText;
    private Button mInserButton;
    private UserRegistrationHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new UserRegistrationHandler(this);

        setUI();

    }

    private void setUI() {
        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mEmailEditText = (EditText) findViewById(R.id.emailEditText);
        mPhoneEditText = (EditText) findViewById(R.id.phoneEditText);
        mPlaceEditText = (EditText) findViewById(R.id.placeEditText);

        mInserButton = (Button) findViewById(R.id.insertButton);

        mInserButton.setOnClickListener(this);

        ArrayList<UserModel> userModels = handler.getAllUserDetails();

        for (UserModel userModel : userModels) {
            Toast.makeText(this, userModel.getName(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {

        UserModel userModel = new UserModel();

        userModel.setName(mNameEditText.getText().toString());
        userModel.setEmail(mEmailEditText.getText().toString());
        userModel.setPhone(mPhoneEditText.getText().toString());
        userModel.setPlace(mPlaceEditText.getText().toString());


        boolean isInserted = handler.insertUserDetails(userModel);

        if (isInserted) {
            Toast.makeText(this, "Inserted Success", Toast.LENGTH_SHORT).show();
        }

    }
}
