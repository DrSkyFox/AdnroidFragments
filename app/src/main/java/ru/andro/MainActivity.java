package ru.andro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(this.getClass().getName(), "start");

        CitiesFragment citiesFragment = new CitiesFragment();


//        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.coats_of_arms_image_container, CoastOfArmFragment.newInstance(0))
//                    .commit();
//        } else {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.fragment_container, citiesFragment)
//                    .commit();
//        }


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, citiesFragment)
                .commit();

//        MyConf myConf = new MyConf();
//        myConf.color ="red";
//        myConf.height =100;
//        myConf.length =200;
//
//        IConfFluent config = new ConfigurationFluent().SetColor("black").SetHeight(100).SetLength(200);
    }


    private boolean isLandscape() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }


}


interface IConfig {
    String color();

    int height();

    int length();

}

class MyConf implements IConfig {

    String color;
    int height;
    int length;

    @Override
    public String color() {
        return null;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }
}

interface IConfFluent {
    IConfFluent SetColor(String color);

    IConfFluent SetHeight(int height);

    IConfFluent SetLength(int length);
}

class ConfigurationFluent implements IConfFluent {

    String color;
    int height;
    int length;

    @Override
    public IConfFluent SetColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public IConfFluent SetHeight(int height) {
        this.height = height;
        return this;
    }

    @Override
    public IConfFluent SetLength(int length) {
        this.length = length;
        return this;
    }
}