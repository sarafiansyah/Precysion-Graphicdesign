package com.rafiansyahdesign.precysion.projects;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.rafiansyahdesign.precysion.R;
import com.rafiansyahdesign.precysion.model.Projects;

public class Projects_Create extends AppCompatActivity implements View.OnClickListener {

    private EditText edtTitle, edtNama, edtArticle;
    private Button btnSave;

    private Projects publicProjects;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectscreate);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        edtNama = findViewById(R.id.edt_nama);
        edtTitle = findViewById(R.id.edt_title);
        edtArticle = findViewById(R.id.edt_article);
        btnSave = findViewById(R.id.btn_save);

        btnSave.setOnClickListener(this);

        publicProjects = new Projects();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_save) {
            saveProjects();
        }

    }

    private void saveProjects()
    {
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

            Toast.makeText(Projects_Create.this, "New Article Created", Toast.LENGTH_SHORT).show();

            DatabaseReference dbProjects = mDatabase.child("Projects");

            String id = dbProjects.push().getKey();
            publicProjects.setId(id);
            publicProjects.setTitle(title);
            publicProjects.setNama(nama);
            publicProjects.setArticle(article);
            publicProjects.setPhoto("");

            //insert data
            dbProjects.child(id).setValue(publicProjects);

            finish();

        }
    }
}