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

public class menu_setting extends Fragment {

    public static menu_setting newInstance(){
        menu_setting setting = new menu_setting();
        return setting;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_setting, container, false);

        return view;
    }
}
