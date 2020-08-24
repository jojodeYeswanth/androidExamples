package com.jojo.movietix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<movieDetails> movieDetails;

    public MovieAdapter(Context context, int layout, ArrayList<movieDetails> movieDetails) {
        this.context = context;
        this.layout = layout;
        this.movieDetails = movieDetails;
    }

    @Override
    public int getCount() {
        return movieDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return movieDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtGenre;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtName = row.findViewById(R.id.txtName);
            holder.txtGenre = row.findViewById(R.id.txtGenre);
            holder.imageView = row.findViewById(R.id.imgMovie);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        movieDetails details = movieDetails.get(position);

        holder.txtName.setText(details.getTitle());
        holder.txtGenre.setText(details.getGenre());

        byte[] foodImage = details.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        holder.imageView.setImageBitmap(bitmap);
        return row;
    }
}