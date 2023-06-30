package com.rafiansyahdesign.precysion.projects_adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.rafiansyahdesign.precysion.R;
import com.rafiansyahdesign.precysion.model.Projects;

import java.util.ArrayList;

public class ProjectsAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Projects> projectsList = new ArrayList<>();

    public void setMahasiswaList(ArrayList<Projects> projectsList) {
        this.projectsList = projectsList;
    }

    public ProjectsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return projectsList.size();
    }

    @Override
    public Object getItem(int i) {
        return projectsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;

        if (itemView == null) {
            itemView = LayoutInflater.from(context)
                    .inflate(R.layout.item_projects, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Projects projects = (Projects) getItem(i);
        viewHolder.bind(projects);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtTitle, txtName, txtArticle;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_nama);
            txtTitle = view.findViewById(R.id.txt_nim);
        }

        void bind(Projects projects) {
            txtName.setText(projects.getNama());
            txtTitle.setText(projects.getTitle());
        }
    }
}