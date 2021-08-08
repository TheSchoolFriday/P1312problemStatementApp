package sg.edu.rp.c346.id20046797.p1312problemstatementapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivButton = findViewById(R.id.imageView1);

        ivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, taskListActivity.class);
                AlertDialog.Builder construct = new AlertDialog.Builder(MainActivity.this);
                construct.setTitle("Beta App!");
                construct.setMessage("This application is still in the works, you are unable to set a reminder from within the application.\nBut you can add in new Folders.");
                construct.setPositiveButton("Understood", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intent);
                    }
                });

                AlertDialog finalConstruct = construct.create();
                finalConstruct.show();

            }
        });
    }
}