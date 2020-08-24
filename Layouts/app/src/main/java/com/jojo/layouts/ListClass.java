package com.jojo.layouts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListClass extends Fragment {
    ListView listView;
    String[] listItem = {
            "List Item 1","List Item 2","List Item 3","List Item 4","List Item 5",
            "List Item 6","List Item 7","List Item 8","List Item 9","List Item 10",
            "List Item 11","List Item 12","List Item 13","List Item 14","List Item 15",
            "List Item 16","List Item 17","List Item 18","List Item 19","List Item 20",};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list, container, false);
        ArrayAdapter adapter = new ArrayAdapter<>(getActivity(), R.layout.listitem_layout, listItem);
        listView = view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        return view;
    }

}
