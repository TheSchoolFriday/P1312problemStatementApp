package sg.edu.rp.c346.id20046797.p1312problemstatementapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class taskListActivity extends AppCompatActivity {
    ListView activatedView;
    ImageView ivButton;
    ArrayList<todoList> activatedList = new ArrayList<>();

    // WILDCARD: /!@#$%^&*\

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        activatedView = findViewById(R.id.listView);

        ivButton = findViewById(R.id.ivAddButton);


        // Dummy Test
        activatedList.add(new todoList(
                0,
                "C346",
                "Android Programming",
                "Android programming teaches you about Android is by far the best Module to ever exist."));
        activatedList.add(new todoList(
                1,
                "C218",
                "UI / UX Design"));
        activatedList.add(new todoList(
                2,
                "C203",
                "PHP Web App"));

        CustomAdapter activatedAdapter = new CustomAdapter(this, R.layout.customlayout, activatedList);
        activatedView.setAdapter(activatedAdapter);

        activatedView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(taskListActivity.this, viewListActivity.class);
                intent.putExtra("selectedName", activatedList.get(position));
                startActivity(intent);
            }
        });

        ivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                final EditText moduleName = viewDialog.findViewById(R.id.etmid);
                final EditText moduleDescription = viewDialog.findViewById(R.id.etmid2);
                final EditText moduleAdditional = viewDialog.findViewById(R.id.etmid3);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(taskListActivity.this);

                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Add new Folder");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (moduleName.getText().toString().trim().isEmpty() || moduleDescription.getText().toString().trim().isEmpty()) {
                            Toast.makeText(taskListActivity.this, "Required Fields are Empty.", Toast.LENGTH_SHORT).show();
                        } else {
                            activatedList.add(new todoList(4, moduleName.getText().toString(), moduleDescription.getText().toString(), moduleAdditional.getText().toString()));
                            activatedAdapter.notifyDataSetChanged();
                        }
                        
                    }
                });

                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });
    }
}

