package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import code.*;

public class CreatingGroupActivity extends AppCompatActivity {
    public static final String GROUP_ID = "group.name";
    public static final String PEOPLE_ID = "people.name";

    public static Group myGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_creating_group);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_creating_group), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button submitData = findViewById(R.id.submitGroupData);
        submitData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupListActivity();
            }
        });
    }

    private void groupListActivity(){
        EditText groupNameInput = findViewById(R.id.groupNameInput);
        EditText peopleNamesInput = findViewById(R.id.groupPeopleInput);
        Intent switchToListActivity = new Intent(this, GroupListActivity.class);

        String groupName = groupNameInput.getText().toString();
        String peopleNames = peopleNamesInput.getText().toString();

        myGroup = new Group(groupName);

        // switchToListActivity.putExtra(GROUP_ID, groupName);
        switchToListActivity.putExtra(PEOPLE_ID, peopleNames);
        startActivity(switchToListActivity);
    }
}