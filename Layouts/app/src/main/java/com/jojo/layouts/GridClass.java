package com.jojo.layouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GridClass extends Fragment {
    private static final String[] numbers = new String[] {
            "Grid 1", "Grid 2", "Grid 3", "Grid 4", "Grid 5",
            "Grid 6", "Grid 7", "Grid 8", "Grid 9", "Grid 10",
            "Grid 11", "Grid 12", "Grid 13", "Grid 14", "Grid 15",
            "Grid 16", "Grid 17", "Grid 18", "Grid 19", "Grid 20",
            "Grid 21", "Grid 22", "Grid 23", "Grid 24", "Grid 25",
            "Grid 26", "Grid 27", "Grid 28", "Grid 29", "Grid 30",
            "Grid 31", "Grid 32"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.grid, container, false);
        GridView gridView = view.findViewById(R.id.gridview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, numbers);
        gridView.setAdapter(adapter);
        return view;
    }
}
