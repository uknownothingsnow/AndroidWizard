package viewpagerdemo.android.baidao.com.androidwizard;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.common.collect.Lists;
import com.mobsandgeeks.adapters.InstantAdapter;
import com.mobsandgeeks.adapters.ViewHandler;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SingleChoiceFragment extends Fragment {
    protected static final String ARG_PAGE_ID = "pageId";
    protected static final String ARG_PAGE_TITLE = "pageTitle";
    int pageId;
    String pageTitle;
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
            pageId = getArguments().getInt(ARG_PAGE_ID);
            pageTitle = getArguments().getString(ARG_PAGE_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_single_choice, container, false);
        ButterKnife.inject(this, view);

        List<String> items = Lists.newArrayList("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item9", "item10", "item11", "item12", "item13");

        InstantAdapter<String> adapter = new InstantAdapter<String>(getActivity(), R.layout.list_item_single_choice, String.class, items);
        adapter.setViewHandler(android.R.id.text1, new ViewHandler<String>() {
            @Override
            public void handleView(ListAdapter adapter, View parent, View view, String instance, int position) {
                ((CheckedTextView) view).setText(instance);
            }
        });
        listView.setAdapter(adapter);

        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (null != onPageInteractionListener) {
                    onPageInteractionListener.onPageInteraction(pageFragmentCallback.getPage(pageId));
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
