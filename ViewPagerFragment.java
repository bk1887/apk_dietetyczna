package com.pl.edu.prz.aplikacjadietetyczna;
//import android.app.Fragment;
import android.os.Bundle;// importowanie systemu operacyjnego android do obiektu Bundle
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;//importujemy wsparcie v4
import android.support.v4.app.FragmentPagerAdapter;//importujemy wsparcie v4
import android.support.v4.view.ViewPager;//wsparcie v4 jest importowane
import android.view.LayoutInflater;// importowanie instalacji LayoutInflater
import android.view.View;// importowanie okna widokowego androida
import android.view.ViewGroup;//importowanie  grupy widoków  android

public class ViewPagerFragment extends Fragment {// publiczna klasa ViewPagerFragment rozszerzenie działania aplikacji Fragment
    public static final String KEY_RECIPE_INDEX ="recipe_index";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        int index = getArguments().getInt(KEY_RECIPE_INDEX);//pobranie odpowiedniego indeksu
        //Toast.makeText(getActivity(), Recipes.names[index], Toast.LENGTH_LONG).show();
        getActivity().setTitle(Diets.names[index]);//ustawienie tytułu jako nazwa diety
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);//pobranie widoku layout z fragment_viewpager
        final Skladniki skladniki = new Skladniki();
        Bundle bundle = new Bundle();//odwzorowanie kluczy literowych string
        bundle.putInt(KEY_RECIPE_INDEX, index);//odpowiedziane za numer indexu przepisu
        skladniki.setArguments(bundle);

        bundle = new Bundle();//odwzorowanie kluczy literowych string
        bundle.putInt(KEY_RECIPE_INDEX, index);//ustalenie numeru przepisu
        ViewPager viewPager=(ViewPager) view.findViewById(R.id.viewPager);//znalezienie  i przypisanie zmiennej view_pager
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()){//pobranie fragmentu z dziedziczonego elementu
            @Override
            public Fragment getItem(int i) {//pobranie elementu o numerze zmiennej i

                return skladniki;//zwróć skłładniki
            }
             @Nullable
            @Override
            public  CharSequence getPageTitle (int position) {//ustalenie nagłówka
                 //return super.getPageTitle(position);
                     return "Składniki";//zwróć składniki
             }
            @Override
            public int getCount() {return 1;}
        });
        TabLayout tabLayout= (TabLayout) view.findViewById(R.id.tableLayout);//służy do implementacji poziomych zakładek
        tabLayout.setupWithViewPager(viewPager);
        return view;//zwróć widok
    }
    @Override
    public void onStop(){
        super.onStop();
        getActivity().setTitle("Przepisy158329");
    }
}
