package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

import code.*;

public class GroupListActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> renameGroupActivity;

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
        // All functionality is tied in this class

        setGroupName();

        Intent intent = getIntent();
        String namesString = intent.getStringExtra(CreatingGroupActivity.PEOPLE_ID);
        settingMembers(namesString);

        // Remove Group Button
        Button removeGroupButton = findViewById(R.id.removeGroup);
        removeGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeGroup();
            }
        });

        // Rename Group Button //
        renameGroupActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    setGroupName();
                }
            }
        );

        Button renameGroupButton = findViewById(R.id.renameGroup);
        renameGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchRenameGroupActivity();
            }
        });
        // ---------------------- //

        // Remove Members Buttons //
        Button removeMember1 = findViewById(R.id.removeGroupMember1);
        removeMember1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row1 = findViewById(R.id.TableRow1);
                TextView mem1 = findViewById(R.id.groupMember1);
                removeMemberRow(row1, mem1);
            }
        });

        Button removeMember2 = findViewById(R.id.removeGroupMember2);
        removeMember2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row2 = findViewById(R.id.TableRow2);
                TextView mem2 = findViewById(R.id.groupMember2);
                removeMemberRow(row2, mem2);
            }
        });


        Button removeMember3 = findViewById(R.id.removeGroupMember3);
        removeMember3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row3 = findViewById(R.id.TableRow3);
                TextView mem3 = findViewById(R.id.groupMember3);
                removeMemberRow(row3, mem3);
            }
        });

        Button removeMember4 = findViewById(R.id.removeGroupMember4);
        removeMember4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row4 = findViewById(R.id.TableRow4);
                TextView mem4 = findViewById(R.id.groupMember4);
                removeMemberRow(row4, mem4);
            }
        });

        Button removeMember5 = findViewById(R.id.removeGroupMember5);
        removeMember5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableRow row5 = findViewById(R.id.TableRow5);
                TextView mem5 = findViewById(R.id.groupMember5);
                removeMemberRow(row5, mem5);
            }
        });

        int[] addChargeButtonIds = {
                R.id.addCharge1,
                R.id.addCharge2,
                R.id.addCharge3,
                R.id.addCharge4,
                R.id.addCharge5
        };

        for (int i = 0; i < addChargeButtonIds.length; i++) {
            final int personIndex = i;
            Button btn = findViewById(addChargeButtonIds[i]);
            btn.setOnClickListener(v -> {
                Intent chargeIntent = new Intent(GroupListActivity.this,
                        AddChargeActivity.class);
                chargeIntent.putExtra("person_index", personIndex);
                startActivity(chargeIntent);
            });
        }


    }
    private void removeGroup(){
        if(CreatingGroupActivity.myGroup.isEmptyGroup()) {
            finish();
        }
    }

    private void switchRenameGroupActivity(){
        Intent renameGroupIntent = new Intent(this, RenameGroupActivity.class);
        renameGroupActivity.launch(renameGroupIntent);
    }

    private void setGroupName(){
        String groupName = CreatingGroupActivity.myGroup.getGroupName();
        TextView groupNameView = findViewById(R.id.groupName1);

        groupNameView.setText(groupName);
    }

    // Name Handler
    private void settingMembers(String names){
        String[] namesList = names.split(",");
        int[] textViewIds = {
                R.id.groupMember1,
                R.id.groupMember2,
                R.id.groupMember3,
                R.id.groupMember4,
                R.id.groupMember5
        };

        // Creates our people
        for (String name : namesList){
            Person p = new Person(0.0, name.trim());
            CreatingGroupActivity.myGroup.addMember(p);
        }
        // Adds people to the group and display
        for(int i = 0; i < namesList.length; i++){
            TextView member = findViewById(textViewIds[i]);
            Person p = CreatingGroupActivity.myGroup.personList.get(i);
            member.setText(p.getName());
        }
    }

    // Member Removal Handler
    private void removeMemberRow(TableRow row, TextView name){
        TableLayout memberTable = findViewById(R.id.MemberTableLayout);
        String memberName = name.getText().toString();

        for (int i = 0; i < CreatingGroupActivity.myGroup.personList.size(); i++){
            Person p = CreatingGroupActivity.myGroup.personList.get(i);
            if (p.getName().equals(memberName)){
                if(p.getTotalDebt() <= 0) {
                    CreatingGroupActivity.myGroup.removeMember(p);
                }else{
                    return;
                }
            }
        }
        memberTable.removeView(row);
    }

    protected void onResume() {
        super.onResume();

        int[] paymentViewIds = {
                R.id.groupMemberPayment1,
                R.id.groupMemberPayment2,
                R.id.groupMemberPayment3,
                R.id.groupMemberPayment4,
                R.id.groupMemberPayment5
        };

        for (int i = 0; i < CreatingGroupActivity.myGroup.personList.size(); i++) {
            TextView tv = findViewById(paymentViewIds[i]);
            double debt = CreatingGroupActivity
                    .myGroup
                    .personList
                    .get(i)
                    .getTotalDebt();
            tv.setText(String.format(Locale.US, "$%.2f", debt));
        }
    }
}