package com.rafiansyahdesign.precysion.projects;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rafiansyahdesign.precysion.ProjectsMain;
import com.rafiansyahdesign.precysion.R;
import com.rafiansyahdesign.precysion.model.Projects;

public class Projects_Edit extends AppCompatActivity implements View.OnClickListener {

    private EditText edtTitle, edtNama, edtArticle;
    private Button btnUpdate, btnDelete;

    public static final String EXTRA_PROJECTS = "extra_projects";
    public final int ALERT_DIALOG_CLOSE = 10;
    public final int ALERT_DIALOG_DELETE = 20;

    private Projects projects;
    private String projectsId;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectsedit);

        ImageButton button = (ImageButton) findViewById(R.id.BackButton01);
        final Context context = this;
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context, ProjectsMain.class);
                startActivity(intent);
            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference();

        edtNama = findViewById(R.id.edt_edit_nama);
        edtTitle = findViewById(R.id.edt_edit_nim);
        edtArticle = findViewById(R.id.edt_edit_article);
        btnUpdate = findViewById(R.id.btn_update);
        btnDelete = findViewById(R.id.btn_delete);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        projects = getIntent().getParcelableExtra(EXTRA_PROJECTS);

        if (projects != null) {
            projectsId = projects.getId();
        } else {
            projects = new Projects();
        }

        if (projects != null) {
            edtTitle.setText(projects.getTitle());
            edtNama.setText(projects.getNama());
            edtArticle.setText(projects.getArticle());

        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Article Edited");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_update) {
            updateProjects();
        }
        if (view.getId() == R.id.btn_delete) {
            deleteMahasiswa();
        }

    }

    public void updateProjects() {
        String nama = edtNama.getText().toString().trim();
        String title = edtTitle.getText().toString().trim();
        String article = edtArticle.getText().toString().trim();

        boolean isEmptyFields = false;

        if (TextUtils.isEmpty(nama)) {
            isEmptyFields = true;
            edtNama.setError("Please fill this field!");
        }

        if (TextUtils.isEmpty(title)) {
            isEmptyFields = true;
            edtTitle.setError("Please fill this field!");
        }

        if (TextUtils.isEmpty(title)) {
            isEmptyFields = true;
            edtArticle.setError("Please fill this field!");
        }

        if (! isEmptyFields) {

            Toast.makeText(Projects_Edit.this, "Article Updated", Toast.LENGTH_SHORT).show();

            projects.setTitle(title);
            projects.setNama(nama);
            projects.setArticle(article);
            projects.setPhoto("");

            DatabaseReference dbProjects = mDatabase.child("Projects");

            //update data
            dbProjects.child(projectsId).setValue(projects);

            finish();

        }
    }

    public void deleteMahasiswa() {
        DatabaseReference dbProjects =
                mDatabase.child("Projects").child(projectsId);

        dbProjects.removeValue();

        Toast.makeText(Projects_Edit.this, "Article Deleted",
                Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //pilih menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                //showAlertDialog(ALERT_DIALOG_DELETE);
                break;
            case android.R.id.home:
                showAlertDialog(ALERT_DIALOG_CLOSE);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        showAlertDialog(ALERT_DIALOG_CLOSE);
    }

    private void showAlertDialog(int type) {
        final boolean isDialogClose = type == ALERT_DIALOG_CLOSE;
        String dialogTitle, dialogMessage;

        if (isDialogClose) {
            dialogTitle = "Cancel Edit";
            dialogMessage = "Are you sure wants to cancel the edit?";
        } else {
            dialogTitle = "Confirm Delete";
            dialogMessage = "Are you sure wants to delete?";
        }

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle(dialogTitle);
        alertDialogBuilder.setMessage(dialogMessage)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (isDialogClose) {
                            finish();
                        } else {
                            DatabaseReference dbProjects =
                                    mDatabase.child("Projects").child(projectsId);

                            dbProjects.removeValue();

                            Toast.makeText(Projects_Edit.this, "Article Deleted",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}