package viewpagerdemo.android.baidao.com.androidwizard;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class TextFragment extends Fragment {
    protected static final String ARG_PAGE_ID = "pageId";
    protected static final String ARG_PAGE_TITLE = "pageTitle";
    int id;
    String title;

    protected OnPageInteractionListener pageInteractionListener;
    protected PageFragmentCallback pageFragmentCallback;
    protected EditText name;

    public static TextFragment newInstance(int id, String title) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_ID, id);
        args.putString(ARG_PAGE_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }
    public TextFragment() {
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
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        name = ((EditText) view.findViewById(R.id.editText_name));
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    pageFragmentCallback.getPage(id).setCompleted(false);
                } else {
                    pageFragmentCallback.getPage(id).setCompleted(true);
                }
                if (null != pageInteractionListener) {
                    pageInteractionListener.onPageInteraction(pageFragmentCallback.getPage(id));
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            pageInteractionListener = (OnPageInteractionListener) activity;
            pageFragmentCallback = (PageFragmentCallback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        pageInteractionListener = null;
        pageFragmentCallback = null;
    }
}
