package com.sred.eatright.userInfo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sred.eatright.DatabaseHelper;
import com.sred.eatright.R;
import com.sred.eatright.userDiary.HelpActivity;
import com.sred.eatright.userDiary.HomeActivity;
import com.sred.eatright.userDiary.SearchActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        final int _id = (Integer)getIntent().getExtras().get("id");
        try {
            DatabaseHelper dbGetter = new DatabaseHelper(this);
            Profile profile = dbGetter.GetDB(_id);

            String usersName = profile.getUsersName();
            String userEmail = profile.getUserEmail();
            String userGender = profile.getUserGender();
            String userDOB_month = profile.getUserDOB_month();
            String userDOB_day = profile.getUserDOB_day();
            String userDOB_year = profile.getUserAge();
            String userHeightFeet = profile.getUserHeightFeet();
            String userHeightInches = profile.getUserHeightInches();
            String userGoal = profile.getUserFitnessGoal();
            String userWeight = profile.getUserWeight();


            final TextView user_name = (TextView) findViewById(R.id.user_name);
            user_name.setText(usersName);
            final TextView user_email = (TextView) findViewById(R.id.user_email);
            user_email.setText(userEmail);
            final TextView user_gender = (TextView) findViewById(R.id.user_gender);
            user_gender.setText(userGender);
            final TextView user_dob_month = (TextView) findViewById(R.id.user_dob_month);
            user_dob_month.setText(userDOB_month);
            final TextView user_dob_day = (TextView) findViewById(R.id.user_dob_day);
            user_dob_day.setText(userDOB_day);
            final TextView user_dob_year = (TextView) findViewById(R.id.user_dob_year);
            user_dob_year.setText(userDOB_year);
            final TextView user_heightFeet = (TextView) findViewById(R.id.user_heightFeet);
            user_heightFeet.setText(userHeightFeet);
            final TextView user_heightInches = (TextView) findViewById(R.id.user_heightInches);
            user_heightInches.setText(userHeightInches);
            final TextView user_goal = (TextView) findViewById(R.id.user_goal);
            user_goal.setText(userGoal);
            final TextView user_current_weight = (TextView) findViewById(R.id.user_current_weight);
            user_current_weight.setText(userWeight);
        } catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }



        final EditText updateWeight = (EditText) findViewById(R.id.user_new_weight);
        final Button buttonSave = (Button) findViewById(R.id.button_save);
        final Button button_help = (Button) findViewById(R.id.button_help);
        final Button button_search = (Button) findViewById(R.id.button_search);
        final Button button_home = (Button) findViewById(R.id.button_home);

//        final int userUpdatedWeight =  Integer.parseInt(updateWeight.getText().toString().trim());
//        final DatabaseHelper db;
//        db = new DatabaseHelper(this);

//        buttonSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                db.updateUserWeight(_id,userUpdatedWeight);
//                Intent moveToRefresh = new Intent(ProfileActivity.this, ProfileActivity.class);
//                startActivity(moveToRefresh);
//            }
//    });

        //help button
        button_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHelp = new Intent(ProfileActivity.this, HelpActivity.class);
                moveToHelp.putExtra("id",_id);
                startActivity(moveToHelp);

            }
        });

        //search screen button
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToSearch = new Intent(ProfileActivity.this, SearchActivity.class);
                moveToSearch.putExtra("id",_id);
                startActivity(moveToSearch);
            }
        });

        //home button
        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToHome = new Intent(ProfileActivity.this, HomeActivity.class);
                moveToHome.putExtra("id",_id);
                startActivity(moveToHome);
            }
        });
    }
}
