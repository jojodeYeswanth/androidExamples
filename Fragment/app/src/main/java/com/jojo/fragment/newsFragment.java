package com.jojo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class newsFragment extends Fragment {
    ImageView headImg;
    TextView title, desc;
    List<News> newsList;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    private static final String URL_NEWS = "http://enactive-words.000webhostapp.com/android.php";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("lifyCycle","Fragment onAttach");
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("lifyCycle","Fragment onCreate");
        newsList = new ArrayList<>();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment, container, false);
        headImg = view.findViewById(R.id.headImg);
        title = view.findViewById(R.id.headTitle);
        desc = view.findViewById(R.id.headDesc);
        progressBar = view.findViewById(R.id.progress_circular);
        recyclerView = view.findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        title.setText(R.string.newsheader);
        desc.setText(R.string.news);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadNews();
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d("lifyCycle","Fragment onStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        headImg.setImageResource(R.drawable.crypto);
        Log.d("lifyCycle","Fragment onResume");

    }
    @Override
    public void onPause() {
        super.onPause();
        headImg.setImageResource(R.drawable.crypto);
        progressBar.setVisibility(View.GONE);
        Log.d("lifyCycle","Fragment onPause");
    }
    @Override
    public void onStop() {
        super.onStop();
        headImg.setImageResource(R.drawable.load);
        Log.d("lifyCycle","Fragment onStop");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("lifyCycle","Fragment onDestroyView");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("lifyCycle","Fragment onDestroy");
    }
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("lifyCycle","Fragment onDetach");
    }

    private void loadNews() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_NEWS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject product = array.getJSONObject(i);
                                newsList.add(new News(
                                        product.getInt("id"),
                                        product.getString("title"),
                                        product.getString("body"),
                                        product.getString("contrib")
                                ));
                            }
                            NewsAdapter adapter = new NewsAdapter(getContext(), newsList);
                            progressBar.setVisibility(View.GONE);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }
}
