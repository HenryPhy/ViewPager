package com.example.x1yk;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 第一个页面
 */
public class oneFragment extends Fragment{
    String path = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
    private List<Bean.DataBean> list = new ArrayList<>();
    private TextView one_all;
    private RecyclerView rv;
    public static oneAdapter  one;
    public  static boolean notigy=false;
    public oneFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        new Task().execute();
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(manager);
        one = new oneAdapter(getContext(), list);
        rv.setAdapter(one);

        return view;
    }
    //异步任务
    class Task extends AsyncTask<Void,Void,String>{
    @Override
    protected String doInBackground(Void... voids) {
        return okhttp.getString(path);
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s!=null&&!s.isEmpty()){
            Gson gson = new Gson();
            Bean bean = gson.fromJson(s, Bean.class);
            List<Bean.DataBean> data= bean.getData();
            list.addAll(data);
            one.notifyDataSetChanged();}}}}