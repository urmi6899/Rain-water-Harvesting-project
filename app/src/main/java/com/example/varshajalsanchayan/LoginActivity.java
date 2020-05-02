
package com.example.varshajalsanchayan;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.widget.Toast;
        import android.widget.EditText;
        import android.widget.Button;
        import android.view.View;

public class LoginActivity extends AppCompatActivity {
    String username;
    private EditText Uid;
    private EditText pd;
    private Button lg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Uid = findViewById(R.id.Uid);
        pd = findViewById(R.id.pswd);
        lg = findViewById(R.id.Blogin);

        lg.setOnClickListener(new View.OnClickListener()
                              {
                                  public void onClick(View view)
                                  {
                                      //Toast.makeText(getApplicationContext(),"username is " + Uid.getText().toString(),Toast.LENGTH_LONG).show();
                                      //Toast.makeText(getApplicationContext(),"password is " + pd.getText().toString(),Toast.LENGTH_LONG).show();

                                      validate(Uid.getText().toString(),pd.getText().toString());
                                  }
                              }
        );
    }

    private void validate(String UserId, String Password)
    {

        if(Password.equals("12345") && (UserId.equals("user")))
        {
           Intent intent = new Intent(this,MainActivity.class);
            username=Uid.getText().toString();

            Toast.makeText(getApplicationContext(),"username is " + username,Toast.LENGTH_LONG).show();

            intent.putExtra("value",username);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
            Uid.requestFocus();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.drawer_menu, menu);
        return true;
    }
}
