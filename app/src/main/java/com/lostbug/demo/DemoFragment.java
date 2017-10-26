package com.lostbug.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link DemoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DemoFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private DemoAdapter mDemoAdapter;

    public DemoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DemoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DemoFragment newInstance() {

        return new DemoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        // Inflate the layout for this fragment
        mRecyclerView = v.findViewById(R.id.main_recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        updateUI();
        return v;
    }

    private void updateUI() {
        DemoLab demoLab = DemoLab.get(getActivity());
        List<DemoItem> items = demoLab.getDemoItems();
        DemoItem demoItem = new DemoItem();
        demoItem.setIconId(R.drawable.ic_map);
        demoItem.setNameId(R.string.demo_map);
        items.add(demoItem);
        mDemoAdapter = new DemoAdapter(items);
        mRecyclerView.setAdapter(mDemoAdapter);
    }

    private class DemoHolder extends RecyclerView.ViewHolder {
        private DemoItem mDemoItem;
        private ImageView mImageView;
        private TextView mTextView;

        public DemoHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.grid_demo_item, parent, false));
            mImageView = itemView.findViewById(R.id.demo_image);
            mTextView = itemView.findViewById(R.id.demo_name);
        }

        public void bind(DemoItem item) {
            mDemoItem = item;
            mImageView.setImageResource(mDemoItem.getIconId());
            mTextView.setText(mDemoItem.getNameId());
        }
    }

    private class DemoAdapter extends RecyclerView.Adapter<DemoHolder> {
        private List<DemoItem> mDemoItems;

        public DemoAdapter(List<DemoItem> items) {
            mDemoItems = items;
        }

        @Override
        public DemoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new DemoHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(DemoHolder holder, int position) {
            holder.bind(mDemoItems.get(position));
        }

        @Override
        public int getItemCount() {
            return mDemoItems.size();
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
