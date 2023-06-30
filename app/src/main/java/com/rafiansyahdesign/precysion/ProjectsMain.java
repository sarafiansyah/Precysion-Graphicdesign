package com.rafiansyahdesign.precysion;

import android.content.Context;
import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rafiansyahdesign.precysion.model.Projects;
import com.rafiansyahdesign.precysion.projects.Projects_Create;
import com.rafiansyahdesign.precysion.projects.Projects_Edit;
import com.rafiansyahdesign.precysion.projects.Projects_View;
import com.rafiansyahdesign.precysion.projects_adapter.ProjectsAdapter;

import java.util.ArrayList;
public class ProjectsMain extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private ProjectsAdapter adapter;
    private ArrayList<Projects> projectsList;
    private Button btnAdd;

    DatabaseReference dbProjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectsmain);

        dbProjects = FirebaseDatabase.getInstance().getReference("Projects");

        listView = findViewById(R.id.lv_list);
        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);

        //list projects
        projectsList = new ArrayList<>();



            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(ProjectsMain.this, Projects_View.class);
                    intent.putExtra(Projects_Edit.EXTRA_PROJECTS, projectsList.get(i));

                    startActivity(intent);
                }
            });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?>  adapterView, View view, int i, long l) {
                Intent intent = new Intent(ProjectsMain.this, Projects_Edit.class);
                intent.putExtra(Projects_Edit.EXTRA_PROJECTS, projectsList.get(i));

                startActivity(intent);

                return true;
            }
        });


        ImageButton button = (ImageButton) findViewById(R.id.BackButton01);
        final Context context = this;
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        dbProjects.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                projectsList.clear();

                for (DataSnapshot mahasiswaSnapshot : dataSnapshot.getChildren()) {
                    Projects mahasiswa = mahasiswaSnapshot.getValue(Projects.class);
                    projectsList.add(mahasiswa);
                }

                ProjectsAdapter adapter = new ProjectsAdapter(ProjectsMain.this);
                adapter.setMahasiswaList(projectsList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ProjectsMain.this, "Terjadi kesalahan.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_add) {
            Intent intent = new Intent(ProjectsMain.this, Projects_Create.class);
            startActivity(intent);
        }
    }
}