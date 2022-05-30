package com.example.chatapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.chatapp.Fragments.ContactFragment;
import com.example.chatapp.Fragments.MessageFragment;
import com.example.chatapp.Fragments.ProfileFragment;
import com.example.chatapp.Fragments.SearchFragment;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MessageFragment();
            case 1:
                return new SearchFragment();
            case 2:
                return new ContactFragment();
            case 3:
                return new ProfileFragment();
            default:
                return new MessageFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
