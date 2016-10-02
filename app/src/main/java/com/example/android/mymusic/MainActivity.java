package com.example.android.mymusic;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.R.attr.onClick;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {
     private ImageButton home;
    private ImageButton myMusic;
    private ImageButton favorite;
    Fragment fragment;
    RadioButton radioButton_home;
    RadioButton radioButton_list;
    RadioButton radioButton_favorite;
    CheckBox button_favorite;
    LinearLayout information;
    ImageView button_playlist;
    CheckBox button_play;
    ImageButton button_nextTrack;
    Toast mToast=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.radioButton_home:
            getSupportFragmentManager().beginTransaction().add(R.id.container,new HomeFragment())
                    .commit();
                break;
            case R.id.radioButton_list:
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new MyMusicFragment())
                        .commit();
                break;
            case R.id.radioButton_favorite:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new FavoriteFragment())
                        .commit();
                break;
        }
        radioButton_home= (RadioButton) findViewById(R.id.radioButton_home);
        radioButton_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment())
                        .commit();
            }
        });
        radioButton_list= (RadioButton) findViewById(R.id.radioButton_list);
        radioButton_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new MyMusicFragment())
                        .commit();
            }
        });
        radioButton_favorite= (RadioButton) findViewById(R.id.radioButton_favorite);
        radioButton_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new FavoriteFragment())
                        .commit();
            }
        });
        home= (ImageButton) findViewById(R.id.home);
        myMusic= (ImageButton) findViewById(R.id.myMusic);
        favorite= (ImageButton) findViewById(R.id.favorite);
        fragment=new Fragment();

        home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment())
            .commit();
            }
        });
        myMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new MyMusicFragment())
                        .commit();
                Log.d("我的音乐","执行了");
            }
        });
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new FavoriteFragment())
                        .commit();
            }
        });
        button_favorite= (CheckBox) findViewById(R.id.Button_favorite);
        button_favorite.setOnClickListener(new View.OnClickListener() {
            String toast;
            @Override
            public void onClick(View v) {
                if(button_favorite.isChecked()){
                    toast="已加入喜欢";
                }else{
                    toast="移除喜欢";
                }
                show(toast);
            }
        });
        information= (LinearLayout) findViewById(R.id.information);
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playPageIntent=new Intent(MainActivity.this,PlayActivity.class);
                startActivity(playPageIntent);
            }
        });
        button_playlist= (ImageView) findViewById(R.id.Button_playlist);
        button_playlist.setOnClickListener(new View.OnClickListener() {
            String toast;
            @Override
            public void onClick(View v) {
                toast="正在播放的歌单";
                show(toast);
            }
        });
        button_play= (CheckBox) findViewById(R.id.Button_play);
        button_play.setOnClickListener(new View.OnClickListener() {
            String toast;
            @Override
            public void onClick(View v) {
                if(button_play.isChecked()){
                    toast="暂停";
                }else{
                    toast="播放";
                }
                show(toast);
            }
        });
        button_nextTrack= (ImageButton) findViewById(R.id.Button_nextTrack);
        button_nextTrack.setOnClickListener(new View.OnClickListener() {
            String toast;
            @Override
            public void onClick(View v) {
                toast="下一首";
                show(toast);
            }
        });
    }



    private void show(String msg){
        if(mToast==null){
            mToast=Toast.makeText(this,msg,Toast.LENGTH_LONG);
        }else {
            mToast.setText(msg);
        }
        mToast.show();
    }

}
