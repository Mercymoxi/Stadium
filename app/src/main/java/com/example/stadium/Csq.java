package com.example.stadium;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Csq extends Fragment01 {

    private View view;
    private EditText a;
    private Button  b;
//    private String tel;
    private int i,j,q;
    private String w,e,r;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        final List<String> sportList = new ArrayList<>();
        final List<String> dateList = new ArrayList<>();
        final List<String> timeList = new ArrayList<>();
        final List<Integer> sidList = new ArrayList<>();

        view=inflater.inflate(R.layout.fragment_csq,container,false);

                List<Custom> customList = DataSupport.select("id").where("account = ?",MainActivity.ina).find(Custom.class);
                i = customList.get(0).getId();
                Custom custom = DataSupport.find(Custom.class,i,true);
                List<Subscribe> subscribeList = custom.getSubscribeList();
                for (j=0;j<subscribeList.size();j++) {
                    q=subscribeList.get(j).getId();
                    sidList.add(q);
                    w=subscribeList.get(j).getChoose_sport();
                    sportList.add(w);
                    e=subscribeList.get(j).getChoose_date();
                    dateList.add(e);
                    r=subscribeList.get(j).getChoose_time();
                    timeList.add(r);
                    ArrayAdapter<String> adapter_num = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,sportList);
                    ArrayAdapter<String> adapter_name = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,dateList);
                    ArrayAdapter<String> adapter_price = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,timeList);
                    ArrayAdapter<Integer> adapter_leftnum = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,sidList);
                    ListView id_lv = (ListView) view.findViewById(R.id.sname);
                    id_lv.setAdapter(adapter_name);
                    ListView date_lv = (ListView) view.findViewById(R.id.sprice);
                    date_lv.setAdapter(adapter_price);
                    ListView time_lv = (ListView) view.findViewById(R.id.snum);
                    time_lv.setAdapter(adapter_num);
                    ListView left_lv = (ListView) view.findViewById(R.id.slnum);
                    left_lv.setAdapter(adapter_leftnum);
                }

        return view;
    }

}
