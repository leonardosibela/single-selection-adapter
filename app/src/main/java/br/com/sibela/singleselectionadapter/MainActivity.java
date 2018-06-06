package br.com.sibela.singleselectionadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView stringRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringRecycler = findViewById(R.id.string_recycler);
        stringRecycler.setHasFixedSize(false);
        stringRecycler.setLayoutManager(new LinearLayoutManager(stringRecycler.getContext()));
        stringRecycler.setAdapter(new StringAdapter(getStrings()));
    }

    public List<String> getStrings() {

        List<String> strings = new ArrayList<>();

        strings.add("Android Dev BR");
        strings.add("AsyncTask");
        strings.add("Runtime Permission");
        strings.add("Retrofit");
        strings.add("Android Jetpack");
        strings.add("#PerfMatters");
        strings.add("Firebase");
        strings.add("Fabric");
        strings.add("MVP vs MVVM");
        strings.add("Constraint Layout");


        return strings;
    }
}
