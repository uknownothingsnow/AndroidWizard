package viewpagerdemo.android.baidao.com.androidwizard;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SingleChoiceFragment extends Fragment {
    protected static final String ARG_PAGE_ID = "id";
    protected static final String ARG_PAGE_TITLE = "title";
    int id;
    String title;
    @InjectView(R.id.list)
    ListView listView;

    protected OnPageInteractionListener onPageInteractionListener;
    protected PageFragmentCallback pageFragmentCallback;

    public static SingleChoiceFragment newInstance(int id, String title) {
        SingleChoiceFragment fragment = new SingleChoiceFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_ID, id);
        args.putString(ARG_PAGE_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }
    public SingleChoiceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt(ARG_PAGE_ID);
            title = getArguments().getString(ARG_PAGE_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single_choice, container, false);
        ButterKnife.inject(view);

        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onPageInteractionListener) {
                    onPageInteractionListener.onPageInteraction(pageFragmentCallback.getPage(id));
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            onPageInteractionListener = (OnPageInteractionListener) activity;
            pageFragmentCallback = (PageFragmentCallback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onPageInteractionListener = null;
        pageFragmentCallback = null;
    }
}
