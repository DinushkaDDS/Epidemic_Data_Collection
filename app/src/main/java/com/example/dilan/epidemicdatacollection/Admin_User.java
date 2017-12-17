package com.example.dilan.epidemicdatacollection;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Admin_User extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Admin);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_Admin);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_Admin);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.reports_view);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_Admin);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        //PLEASE SEE THE NORMAL USER FILE TO COMPLETE THIS

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_Admin);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

class patientReport{
    String title,description;

    public patientReport(String x, String y){
        this.title = x;
        this.description = y;
    }

    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
}

class reportAdapter extends RecyclerView.Adapter<reportAdapter.reportHolder>{
    List<patientReport> reportList;

    class reportHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView reportTitle, reportDescription;

        public reportHolder(View view){
            super(view);
            reportTitle = (TextView) view.findViewById(R.id.report_title);
            reportDescription = (TextView) view.findViewById(R.id.report_description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //Creating the Touch event for the news item click
        }
    }

    public reportAdapter(List<patientReport> x){
        //implement the getting values from database in here
        reportList = x;
    }

    @Override
    public reportAdapter.reportHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View reportView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.report_single_row, parent,false);

        return new reportAdapter.reportHolder(reportView);
    }

    @Override
    public void onBindViewHolder(reportAdapter.reportHolder holder, int position) {

//        set the News object Items appropriately to the view as following example
        patientReport mReports = reportList.get(position);
        holder.reportTitle.setText(mReports.getTitle());
        holder.reportDescription.setText(mReports.getDescription());

    }
    @Override
    public int getItemCount() {

        return reportList.size();
    }
}
