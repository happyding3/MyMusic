package com.example.android.mymusic;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.android.mymusic.R.id.ranking_list;


public class HomeFragment extends Fragment {

TextView recommend_song;
    TextView ranking_list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_home, container, false);
        recommend_song= (TextView) rootView.findViewById(R.id.recommend_song);
recommend_song.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(),SongListActivity.class);
        startActivity(intent);
    }
});
       ranking_list= (TextView) rootView.findViewById(R.id.ranking_list);
        ranking_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SongListActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    }

