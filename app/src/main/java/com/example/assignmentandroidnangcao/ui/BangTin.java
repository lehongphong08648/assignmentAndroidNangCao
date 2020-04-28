package com.example.assignmentandroidnangcao.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.assignmentandroidnangcao.Adapter.AdapterBangTin;
import com.example.assignmentandroidnangcao.Model.Item;
import com.example.assignmentandroidnangcao.MainActivity;
import com.example.assignmentandroidnangcao.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BangTin extends AppCompatActivity {
    String url = "https://vnexpress.net/rss/thoi-su.rss";
RecyclerView lvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_tin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvContent = findViewById(R.id.lvContent);
        LinearLayoutManager manager = new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false);
        lvContent.setLayoutManager(manager);

        GetDataTask getDataTask = new GetDataTask();

        getDataTask.execute(url);
    }

    class GetDataTask extends AsyncTask<String, Long, List<Item>> {

        @Override
        protected List<Item> doInBackground(String... strings) {


            List<Item> newsList = new ArrayList<>();


            try {

                URL url = new URL(strings[0]);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();


                XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
                xmlPullParserFactory.setNamespaceAware(false);

                XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();

                xmlPullParser.setInput(inputStream, "utf-8");

                int eventType = xmlPullParser.getEventType();
                Item news = null;
                String text = "";
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    String name = xmlPullParser.getName();
                    switch (eventType) {
                        case XmlPullParser.START_TAG:
                            if (name.equals("item")) {
                                news = new Item();
                            }
                            break;

                        case XmlPullParser.TEXT:
                            text = xmlPullParser.getText();
                            break;

                        case XmlPullParser.END_TAG:
                            if (news != null && name.equalsIgnoreCase("title")) {
                                news.title = text;
                            } else if (news != null && name.equalsIgnoreCase("description")) {
                                news.description = text;
                            } else if (news != null && name.equalsIgnoreCase("pubdate")) {
                                news.pubDate = text;
                            } else if (news != null && name.equalsIgnoreCase("link")) {
                                news.link = text;
                            } else if (news != null && name.equalsIgnoreCase("guiid")) {
                                news.guiid = text;
                            } else if (name.equalsIgnoreCase("item")) {
                                newsList.add(news);
                            }
                            break;

                    }

                    eventType = xmlPullParser.next();
                }
            } catch (Exception e) {
                Log.e("Exception", e.getMessage());
            }

            return newsList;
        }


        @Override
        protected void onPostExecute(List<Item> news) {
            super.onPostExecute(news);

            Toast.makeText(BangTin.this,"Size :" + news.size(),
                    Toast.LENGTH_SHORT).show();

            AdapterBangTin adapter= new AdapterBangTin(BangTin.this,news);
            lvContent.setAdapter(adapter);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.replay,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.replay){
//            GetDataTask getDataTask = new GetDataTask();
//            getDataTask.execute(url);
//        }

        startActivity( new Intent(BangTin.this, MainActivity.class));
        return super.onOptionsItemSelected(item);
    }
}
