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

public class menu_stats extends Fragment {

    public static menu_stats newInstance(){
        menu_stats stats = new menu_stats();
        return stats;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_stats, container, false);

        return view;
    }
}
