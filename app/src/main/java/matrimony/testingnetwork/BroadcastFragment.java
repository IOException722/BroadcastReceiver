package matrimony.testingnetwork;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BroadcastFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BroadcastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BroadcastFragment extends Fragment {

    Button bt1,bt2;
    TextView mtext,mtext1;
    EditText medit1,medit2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BroadcastFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BroadcastFragment newInstance(String param1, String param2) {
        BroadcastFragment fragment = new BroadcastFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public BroadcastFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_broadcast, container, false);
        bt1=(Button)view.findViewById(R.id.btn1);
        bt2=(Button)view.findViewById(R.id.btn2);
        medit1=(EditText)view.findViewById(R.id.et1);
        medit2=(EditText)view.findViewById(R.id.et2);
        mtext=(TextView)view.findViewById(R.id.tv1);
        mtext1=(TextView)view.findViewById(R.id.tv2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gettext1= medit1.getText().toString();

                Intent broadcastIntent = new Intent();
                broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);

                broadcastIntent.setAction(Intent.ACTION_DEFAULT   /*BroadcastReceiver1.RECEIVER_KEY1*/);
                broadcastIntent.putExtra("key", gettext1/*jsonReader(result)*/);
                getActivity().sendBroadcast(broadcastIntent);

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gettext2 = medit2.getText().toString();
                Intent broadcastIntent = new Intent();
                broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
                broadcastIntent.setAction(BroadcastReceiver2.RECEIVER_KEY2);
                broadcastIntent.putExtra("Ki", gettext2/*jsonReader(result)*/);
                getActivity().sendBroadcast(broadcastIntent);

            }
        });
        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public  void changedText1(String input)
    {
        mtext.setText(input);
    }

    public  void changedText2(String input)
    {
        mtext1.setText(input);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
