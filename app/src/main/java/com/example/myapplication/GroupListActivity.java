package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import code.*;

public class GroupListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_group_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.group_list), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //todo All our functional code should just be used only in this class/activity

        setGroupName();

        Intent intent = getIntent();
        String namesString = intent.getStringExtra(CreatingGroupActivity.PEOPLE_ID);
        settingMembers(namesString);

        // Remove Group Button
        Button removeGroupButton = findViewById(R.id.removeGroup);
        removeGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo make method to check if there are no people left
                removeGroup();
            }
        });

        // Rename Group Button //
        Button renameGroupButton = findViewById(R.id.renameGroup);
        renameGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchRenameGroupActivity();
            }
        });

        // Remove Members Buttons //
        Button removeMember1 = findViewById(R.id.removeGroupMember1);
        removeMember1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row1 = findViewById(R.id.TableRow1);
                removeMemberRow(row1);
            }
        });

        Button removeMember2 = findViewById(R.id.removeGroupMember2);
        removeMember2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row2 = findViewById(R.id.TableRow2);
                removeMemberRow(row2);
            }
        });


        Button removeMember3 = findViewById(R.id.removeGroupMember3);
        removeMember3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row3 = findViewById(R.id.TableRow3);
                removeMemberRow(row3);
            }
        });

        Button removeMember4 = findViewById(R.id.removeGroupMember4);
        removeMember4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row4 = findViewById(R.id.TableRow4);
                removeMemberRow(row4);
            }
        });

        Button removeMember5 = findViewById(R.id.removeGroupMember5);
        removeMember5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row5 = findViewById(R.id.TableRow5);
                removeMemberRow(row5);
            }
        });

    }
    private void removeGroup(){
        finish();
    }

    private void switchRenameGroupActivity(){
        Intent renameGroupIntent = new Intent(this, RenameGroupActivity.class);
        startActivity(renameGroupIntent);
    }

    private void setGroupName(){
        String groupName = CreatingGroupActivity.myGroup.getGroupName();
        TextView groupNameView = findViewById(R.id.groupName1);

        groupNameView.setText(groupName);
    }

    // Handles names (up to five)
    private void settingMembers(String names){
        String[] namesList = names.split(",");
        int[] textViewIds = {
                R.id.groupMember1,
                R.id.groupMember2,
                R.id.groupMember3,
                R.id.groupMember4,
                R.id.groupMember5
        };

        for (String name : namesList){
            Person p = new Person(0.0, name.trim());
            CreatingGroupActivity.myGroup.addMember(p);
        }

        for(int i = 0; i < namesList.length; i++){
            TextView member = findViewById(textViewIds[i]);
            member.setText(namesList[i].trim());
        }
    }

    private void removeMemberRow(TableRow row){
        TableLayout memberTable = findViewById(R.id.MemberTableLayout);
        //todo Check for debt
        memberTable.removeView(row);
    }
}