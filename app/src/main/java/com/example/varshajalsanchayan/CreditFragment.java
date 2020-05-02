package com.example.varshajalsanchayan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CreditFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;
    private ArrayList<String> entries;

    private DatabaseReference databaseReference;
    //private FirebaseAuth firebaseAuth;
    //private FirebaseUser firebaseUser;
    String ph;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_credit,container,false);
        RelativeLayout relativeLayout = rootView.findViewById(R.id.myRelativeLayout);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.child("ssip-d72f7").getChildren()){
                    entries.add(dataSnapshot1.child("ph2").getValue().toString());
                    //ph=dataSnapshot1.getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        entries.trimToSize();
        int size=entries.size();
        String s = entries.get(size-1);
        final TextView tv = new TextView(getActivity());
        tv.setText("pH is "+s);
        relativeLayout.addView(tv);
        //firebaseAuth = FirebaseAuth.getInstance();
        //firebaseUser = firebaseAuth.getCurrentUser();

        return rootView;

    }
}
