package com.framgia.capstone.utils;

import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.framgia.capstone.R;
import com.squareup.picasso.Picasso;

public class CustomBindingAdapter {
    @BindingAdapter("bind:imageUrlThuoc")
    public static void loadImageThuoc(ImageView imageView, String url) {
        Picasso.with(imageView.getContext()).load(url).placeholder(R.drawable.ic_thuoc).into
            (imageView);
    }

    @BindingAdapter("bind:imageUrlBenh")
    public static void loadImageBenh(ImageView imageView, String url) {
        Picasso.with(imageView.getContext()).load(url).placeholder(R.drawable.ic_benh)
            .into(imageView);
    }

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        Picasso.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter({"adapter"})
    public static void setAdapter(RecyclerView view,
                                  RecyclerView.Adapter adapter) {
        view.setAdapter(adapter);
        view.setHasFixedSize(true);
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView,
                                        LayoutManagers.LayoutManagerFactory layoutManagerFactory) {
        recyclerView.setLayoutManager(layoutManagerFactory.create(recyclerView));
    }

    @BindingAdapter({"bind:adapter"})
    public static void bindViewPagerAdapter(final ViewPager view,
                                            final FragmentPagerAdapter adapter) {
        view.setAdapter(adapter);
    }

    @BindingAdapter({"bind:pager"})
    public static void bindViewPagerTabs(final TabLayout view, final ViewPager pagerView) {
        view.setupWithViewPager(pagerView, true);
        pagerView.setPageTransformer(true, new ZoomOutPageTransformer());
    }

   /* @BindingAdapter({"bind:user"})
    public static void loadHeader(NavigationView view, User user) {
        NavHeaderMainBinding binding =
            NavHeaderMainBinding.inflate(LayoutInflater.from(view.getContext()));
        binding.setUser(user);
        binding.executePendingBindings();
        view.addHeaderView(binding.getRoot());
    }*/
}