package com.example.dilan.epidemicdatacollection;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class Normal_User extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private newsAdapter nAdapter;
    private RecyclerView recyclerView;
    private List<news> newsList = new ArrayList<>();

    news n1 = new news("sdgsdfg","dsffgsdfg","dsgfgsdgf");
    news n2 = new news("sdgsdfg","dsffgsdfg","dsgfgsdgf");
    news n3 = new news("sdgsdfg","dsffgsdfg","dsgfgsdgf");
    news n4 = new news("sdgsdfg","dsffgsdfg","dsgfgsdgf");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal__user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),Reporting.class);
                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.news_view);

        newsList.add(n1);
        newsList.add(n2);
        newsList.add(n3);
        newsList.add(n4);

        if(newsList != null) {
            newsAdapter nAdapter = new newsAdapter(newsList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(nAdapter);
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.normal__user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}


//A CLASS TO CREATE NEWS OBJECT
class news{

    String title, description, date;
    public news(String x, String y, String z){
        title = x;
        description = y;
        date = z;
    }
    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }
}

class newsAdapter extends RecyclerView.Adapter <newsAdapter.newsHolder>{

    List<news> myNews;

    class newsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView newsTitle, newsDescription;

        public newsHolder(View view){
            super(view);
            newsTitle = (TextView) view.findViewById(R.id.news_title);
            newsDescription = (TextView) view.findViewById(R.id.news_description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //ShowREPORT activity
           Intent i = new Intent(view.getContext(),Show_Report.class);
            startActivity(view.getContext(),i,null);
        }
    }

    public newsAdapter(List<news> x){
        //implement the getting values from database in here
        myNews = x;
    }

    @Override
    public newsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View newsView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_single_row, parent,false);

        return new newsHolder(newsView);
    }

    @Override
    public void onBindViewHolder(newsHolder holder, int position) {

//        set the News object Items appropriately to the view as following example
        news mNews = myNews.get(position);
        holder.newsTitle.setText(mNews.getTitle());
        holder.newsDescription.setText(mNews.getDescription());

    }

    @Override
    public int getItemCount() {
        return myNews.size();
    }
}
