package com.jojo.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context mCtx;
    private List<News> newsList;
    public NewsAdapter(Context mCtx, List<News> newsList) {
        this.mCtx = mCtx;
        this.newsList = newsList;
    }
    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_news, null);
        return new NewsViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final NewsViewHolder holder, int position) {
        final News news = newsList.get(position);
        holder.textViewTitle.setText(news.getTitle());
        holder.textViewContributor.setText("By "+news.getContributor());
        holder.textViewDetail.setText(news.getDetail());
        holder.readMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences details = mCtx.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = details.edit();
                    editor.clear();
                    editor.putString("id", Integer.toString(news.getId()));
                    editor.putString("title", news.getTitle());
                    editor.putString("desc", news.getDetail());
                    editor.putString("contrib", news.getContributor());
                    editor.apply();
                    mCtx.startActivity(new Intent(mCtx,DetailActivity.class));
                }
        });
    }
    @Override
    public int getItemCount() {
        return newsList.size();
    }
    class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDetail, textViewContributor, readMore;
        private NewsViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewHead);
            textViewDetail = itemView.findViewById(R.id.detail);
            textViewContributor = itemView.findViewById(R.id.contributor);
            readMore = itemView.findViewById(R.id.readMore);
        }
    }
}