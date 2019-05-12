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

public class Frag05 extends Fragment04 {

    private View view;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view=inflater.inflate(R.layout.activity_frag05,container,false);


        List<Sports> name = DataSupport.select("sports_name").find(Sports.class);
        List<Sports> num = DataSupport.select("sports_num").find(Sports.class);
        List<Sports> price = DataSupport.select("sports_price").find(Sports.class);
        List<Sports> sid = DataSupport.select("id").find(Sports.class);


        List<Integer> priceList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        List<Integer> sidList = new ArrayList<>();

        for (Sports sports:name){
            String a = sports.getName();
            nameList.add(a);
        }
        for (Sports sports:num){
            int b = sports.getNum();
            numList.add(b);
        }
        for (Sports sports:price){
            int a = sports.getPrice();
            priceList.add(a);
        }
        for (Sports sports: sid){
            int a = sports.getId();
            sidList.add(a);
        }





        ArrayAdapter<Integer> adapter_num = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,numList);
        ArrayAdapter<String> adapter_name = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,nameList);
        ArrayAdapter<Integer> adapter_price = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,priceList);
        ArrayAdapter<Integer> adapter_leftnum = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,sidList);
        ListView id_lv = (ListView) view.findViewById(R.id.sname);
        id_lv.setAdapter(adapter_name);
        ListView date_lv = (ListView) view.findViewById(R.id.sprice);
        date_lv.setAdapter(adapter_price);
        ListView time_lv = (ListView) view.findViewById(R.id.snum);
        time_lv.setAdapter(adapter_num);
        ListView left_lv = (ListView) view.findViewById(R.id.slnum);
        left_lv.setAdapter(adapter_leftnum);


        return view;
    }

}
