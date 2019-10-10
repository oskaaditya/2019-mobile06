package id.ac.polinema.idealbodyweight.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.polinema.idealbodyweight.R;
import id.ac.polinema.idealbodyweight.util.BmiIndex;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BmiIndexFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BmiIndexFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BmiIndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmi_index,container,false);
        final EditText weightText = view.findViewById(R.id.weight_Text);
        final EditText heightText = view.findViewById(R.id.height_Text);

        Button calculateButton = view.findViewById(R.id.button_bmi);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    String weightString = weightText.getText().toString();
                    String heightString = heightText.getText().toString();
                    int weight = Integer.parseInt(weightString);
                    int height = Integer.parseInt(heightString);
                    BmiIndex bmiIndex = new BmiIndex(weight,height);
                    mListener.onCalculateBmiIndexClicked(bmiIndex.getIndex());
                }else{
                    Toast.makeText(getActivity(),"Please Input Your Weight and Input Your Height",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name

        void onCalculateBmiIndexClicked(float index);
    }
}
