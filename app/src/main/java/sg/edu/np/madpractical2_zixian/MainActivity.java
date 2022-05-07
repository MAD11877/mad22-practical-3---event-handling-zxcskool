package sg.edu.np.madpractical2_zixian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    User newuser = new User("World", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", 1, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView greet = findViewById(R.id.greeting);
        TextView description = findViewById(R.id.description);
        Button followbtn = findViewById(R.id.followbtn);
        greet.setText("Hello " + newuser.name + "!");
        description.setText(newuser.description);
        followbtn.setText("Follow");

        followbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!newuser.followed){
                    followbtn.setText("Followed");
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                    newuser.followed = true;
                }
                else if (newuser.followed){
                    followbtn.setText("Follow");
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                    newuser.followed = false;
                }
            }
        });

        Intent receive = getIntent();
        int randint = receive.getIntExtra("randomint", newuser.id);
        greet.setText(newuser.name + " " + randint);

        Button msgbtn = findViewById(R.id.messagebtn);
        msgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startmsg = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(startmsg);
            }
        });

    }
}