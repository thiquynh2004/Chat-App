//package com.example.chatapp.Adapter;
//
////import androidx.annotation.NonNull;
////import androidx.annotation.Nullable;
////import androidx.fragment.app.Fragment;
////import androidx.fragment.app.FragmentManager;
////import androidx.fragment.app.FragmentStatePagerAdapter;
////
////import com.example.chatapp.Fragments.ContactFragment;
////import com.example.chatapp.Fragments.MessageFragment;
////import com.example.chatapp.Fragments.ProfileFragment;
////import com.example.chatapp.Fragments.SearchFragment;
//
//import androidx.fragment.app.FragmentStatePagerAdapter;
//
//public class FragmentsAdapter extends FragmentStatePagerAdapter {
//    public FragmentsAdapter(@NonNull FragmentManager fm, int behavior) {
//        super(fm, behavior);
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//      switch (position){
//          case 0: return new MessageFragment();
//          case 1: return new SearchFragment();
//          case 2: return new ContactFragment();
//          case 3: return new ProfileFragment();
//          default:return  new MessageFragment();
//      }
//    }
//
//    @Override
//    public int getCount() {
//        return 4;
//    }
//
//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        String title = null;
//        if(position == 0){
//            title = "Message";
//
//        }
//        if (position == 1){
//            title = "Search";
//
//        }
//        if(position == 2)
//        {
//            title = "Contact";
//        }
//        if(position == 3)
//        {
//            title = "My account";
//        }
//        return title;
//    }
//}
