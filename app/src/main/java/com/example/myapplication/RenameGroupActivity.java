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

public class RenameGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rename_group);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_rename_group), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button renameGroup = findViewById(R.id.submitGroupData);
        renameGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchGroupListActivity();
            }
        });


    }

    private void switchGroupListActivity(){
        Intent renameIntent = new Intent(this, GroupListActivity.class);

        EditText groupNameInput = findViewById(R.id.groupNameInput);
        String groupName = groupNameInput.getText().toString();

        renameIntent.putExtra(CreatingGroupActivity.GROUP_ID, groupName);
        finish();
    }
}