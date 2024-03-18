package com.coderfaysal.hazz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        hashMap = new HashMap<>();
        hashMap.put("title", "হজ্জ কি ?");
        hashMap.put("message", "ইসলামি পরিভাষায়, হজ্জ হল সৌদি আরবের পবিত্র শহর মক্কায় অবস্থিত 'আল্লাহর ঘর' কাবার উদ্দেশ্যে করা একটি তীর্থযাত্রা। এটি শাহাদাহ (আল্লাহর কাছে শপথ), সালাত (প্রার্থনা), যাকাত (দান) এবং সাওম (রমজানের রোজা) এর পাশাপাশি এটি ইসলামের পাঁচটি স্তম্ভের একটি স্তম্ভ।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "হজ্জ কাকে বলে?");
        hashMap.put("message", "হজ্জ আরবি শব্দ। এর আভিধানিক অর্থ হলো – ইচ্ছে করা, ঘোরাফেরা করা, সংকল্প করা, পর্যবেক্ষণ করা ইত্যাদি। \n\n আল্লাহর সন্তুষ্টি লাভের উদ্দেশ্যে কোরআন ও হাদিসের নিয়ম অনুযায়ী নির্দিষ্ট সময়ে কাবা শরিফ এবং নির্দিষ্ট স্থান সমূহে তাওয়াফ ও জিয়ারত করাকে হজ্জ বলে।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "তালবিয়া পড়ার নিয়ম");
        hashMap.put("message", "হজ-ওমরাহ পালনেচ্ছুগণ মিকাতে (যেখানে ইহরাম বাঁধতে হয়) পৌঁছে অথবা তার আগে থেকে গোসল বা ওজু করে (পুরুষগণ ইহরামের কাপড় পরে) ২ রাকাত নামাজ পড়ে কেবলামুখী হয়ে হজ-ওমরার নিয়ত করবে। নিয়ত শেষে অন্তত ৩ বার (পুরুষগণ উচ্চ শব্দে) ৪ নিঃশ্বাসে তালবিয়াহ পাঠ করবে। নিয়ত ও তালবিয়ার দ্বারা ইহরাম বাঁধার কাজ সম্পন্ন করার পর বেশি বেশি তালবিয়াহ পড়তে থাকা উত্তম। হজযাত্রীরা এ তালবিয়া তাওয়াফের স্থানে (বাইতুল্লা/কাবা শরিফ) প্রবেশের আগ পর্যন্ত পুরো পথেই পড়তে থাকবেন। ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "ইহরামের আগে-");
        hashMap.put("message", "ইহরাম বাঁধার পূর্বেই গোঁফ, বগল ও নাভীর নিচের ক্ষৌর কার্যাদি সম্পন্ন করা, নখ কাটা, গোসল করে পাক সাফ হয়ে যাওয়া আবশ্যক। এমনকি ঋতুবর্তী মহিলাদেরও এ সময় গোসল করা মুস্তাহাব। সুগন্ধি ব্যবহার করাও মুস্তাহাব।");
        arrayList.add(hashMap);


        XAdapter xAdapter = new XAdapter();
        recyclerView.setAdapter(xAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }


    private class XAdapter extends RecyclerView.Adapter<XAdapter.XViewHolder>{


        @NonNull
        @Override
        public XViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.items, parent, false );
            return new XViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull XViewHolder holder, int position) {

            hashMap = arrayList.get(position);
            String title = hashMap.get("title");
            String message = hashMap.get("message");

            holder.textView.setText(title);

            holder.cardView.setOnClickListener(view -> {
                Details.TITLE = title;
                Details.MESSAGE = message;
                startActivity(new Intent(MainActivity.this, Details.class));
            });


        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        private class XViewHolder extends RecyclerView.ViewHolder{

            TextView textView;
            CardView cardView;

            public XViewHolder(@NonNull View itemView) {
                super(itemView);

                textView = itemView.findViewById(R.id.textView);
                cardView = itemView.findViewById(R.id.cardView);
            }
        }

    }

}