package kr.phps.vps.miraclehwan.privateseller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Daehwan Kim on 2017-03-12.
 */

public class menu_sell extends Fragment {

    public static menu_sell newInstance(){
        menu_sell sell = new menu_sell();
        return sell;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_sell, container, false);
    }

}
