package com.example.stadium;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Frag03 extends Fragment03{

    private View view;
    private  int i;
    private String  an,as,ac,at;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.activity_frag03, container, false);

        List<Custom> customList = DataSupport.select("id").where("account = ?",MainActivity.ina).find(Custom.class);
        i = customList.get(0).getId();
        Custom custom =DataSupport.find(Custom.class,i);
        an = custom.getName();
        ac = custom.getAccount();
        as = custom.getSex();
        at = custom.getTelephone();


        List<String> acList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        List<String> idList = new ArrayList<>();
        List<String> telList = new ArrayList<>();


            acList.add(ac);
            nameList.add(an);
            idList.add(as);
            telList.add(at);



        ArrayAdapter<String> adapter_account = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, acList);
        ArrayAdapter<String> adapter_name = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, nameList);
        ArrayAdapter<String> adaptersex = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, idList);
        ArrayAdapter<String> adapter_tel = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, telList);
        ListView date_lv = (ListView) view.findViewById(R.id.account);
        date_lv.setAdapter(adapter_account);
        ListView id_lv = (ListView) view.findViewById(R.id.name);
        id_lv.setAdapter(adapter_name);
        ListView time_lv = (ListView) view.findViewById(R.id.id);
        time_lv.setAdapter(adaptersex);
        ListView tellv = (ListView) view.findViewById(R.id.tel);
        tellv.setAdapter(adapter_tel);

        return view;
    }
}
