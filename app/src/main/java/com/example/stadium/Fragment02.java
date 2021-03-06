package com.example.stadium;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Fragment02 extends Fragment{

    private View view;
    private int n1=0,n2=0,n3=0,n4=0,n5=0,n6=0;
    private Integer[] leftnumList= {n1,n2,n3,n4,n5,n6};


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view=inflater.inflate(R.layout.fragment02,container,false);

        List<Sports> name = DataSupport.select("sports_name").find(Sports.class);
        List<Sports> num = DataSupport.select("sports_num").find(Sports.class);
        List<Sports> price = DataSupport.select("sports_price").find(Sports.class);
        List<Subscribe> spkid = DataSupport.select("choose_sport").find(Subscribe.class);

        List<Integer> priceList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        List<String> skindList = new ArrayList<>();

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
        for (Subscribe subscribe: spkid){
            String a = subscribe.getChoose_sport();
            skindList.add(a);
        }

        for (String temp:skindList){
            if (temp == "足球"){
                n1++;
            }
            else if (temp == "篮球"){
                n2++;
            }
            else if (temp == "乒乓球"){
                n3++;
            }
            else if (temp == "tennis"){
                n4++;
            }
            else if (temp == "排球"){
                n5++;
            }
            else if (temp == "羽毛球"){
                n6++;
            }
        }


        ArrayAdapter<Integer> adapter_num = new ArrayAdapter<Integer>(getActivity(),android.R.layout.simple_list_item_1,numList);
        ArrayAdapter<String> adapter_name = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,nameList);
        ArrayAdapter<Integer> adapter_price = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,priceList);
        ArrayAdapter<Integer> adapter_leftnum = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,leftnumList);
        ListView id_lv = (ListView) view.findViewById(R.id.sname);
        id_lv.setAdapter(adapter_name);
        ListView date_lv = (ListView) view.findViewById(R.id.sprice);
        date_lv.setAdapter(adapter_price);
        ListView time_lv = (ListView) view.findViewById(R.id.snum);
        time_lv.setAdapter(adapter_num);
//        ListView left_lv = (ListView) view.findViewById(R.id.slnum);
//        left_lv.setAdapter(adapter_leftnum);

        return view;
    }

}
