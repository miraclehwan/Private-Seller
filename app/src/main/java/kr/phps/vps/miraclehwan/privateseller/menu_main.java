package kr.phps.vps.miraclehwan.privateseller;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Daehwan Kim on 2017-03-12.
 */

public class menu_main extends android.support.v4.app.Fragment {
    
    public static menu_main newInstance(){
        menu_main main = new menu_main();
        return main;
    }
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_main, container, false);
        TextView textView = (TextView) view.findViewById(R.id.menu_main_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "메인이지롱", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
