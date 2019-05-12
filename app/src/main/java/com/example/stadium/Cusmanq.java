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

public class Cusmanq extends Fragment06{

    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.activity_cusmanq, container, false);

        List<Custom> account = DataSupport.select("account").find(Custom.class);
        List<Custom> name = DataSupport.select("name").find(Custom.class);
        List<Custom> id = DataSupport.select("id").find(Custom.class);
        List<Custom> tel = DataSupport.select("telephone").find(Custom.class);

        List<String> acList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        List<Integer> idList = new ArrayList<>();
        List<String> telList = new ArrayList<>();

        for (Custom custom : account) {
            String a = custom.getAccount();
            acList.add(a);
        }

        for (Custom custom : name) {
            String a = custom.getName();
            nameList.add(a);
        }
        for (Custom custom : id) {
            int a = custom.getId();
            idList.add(a);
        }
        for (Custom custom : tel) {
            String a = custom.getTelephone();
            telList.add(a);
        }


        ArrayAdapter<String> adapter_account = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, acList);
        ArrayAdapter<String> adapter_name = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, nameList);
        ArrayAdapter<Integer> adaptersex = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, idList);
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
