package com.example.practical5;

        import android.app.DatePickerDialog;
        import android.app.Dialog;
        import android.os.Bundle;

        import androidx.annotation.NonNull;
        import androidx.fragment.app.DialogFragment;
        import androidx.fragment.app.Fragment;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.DatePicker;

        import java.util.Calendar;

            /**
             * A simple {@link Fragment} subclass.
             * Use the {@link DataPicker#newInstance} factory method to
             * create an instance of this fragment.
             */
            public class DataPicker extends DialogFragment implements DatePickerDialog.OnDateSetListener
            {

                // TODO: Rename parameter arguments, choose names that match
                // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
                private static final String ARG_PARAM1 = "param1";
                private static final String ARG_PARAM2 = "param2";

                // TODO: Rename and change types of parameters
                private String mParam1;
                private String mParam2;


                /**
                 * Use this factory method to create a new instance of
                 * this fragment using the provided parameters.
                 *
                 * @param param1 Parameter 1.
                 * @param param2 Parameter 2.
                 * @return A new instance of fragment DatePickerFragment.
                 */
                // TODO: Rename and change types and number of parameters
                public static DataPicker newInstance(String param1, String param2) {
                    DataPicker fragment = new DataPicker();
                    Bundle args = new Bundle();
                    args.putString(ARG_PARAM1, param1);
                    args.putString(ARG_PARAM2, param2);
                    fragment.setArguments(args);
                    return fragment;
                }

                @Override
                public void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    if (getArguments() != null) {
                        mParam1 = getArguments().getString(ARG_PARAM1);
                        mParam2 = getArguments().getString(ARG_PARAM2);
                    }
                }

                @NonNull
                @Override
                public Dialog onCreateDialog(Bundle savedInstanceState) {
                    final Calendar c = Calendar.getInstance();
                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH);
                    int day = c.get(Calendar.DAY_OF_MONTH);

                    return new DatePickerDialog(getActivity(), this, year, month, day);
                }

                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    MainActivity activity = (MainActivity) getActivity();
                    activity.processDatePickerResult(year, month, day);
                }


            }