package com.example.foodorder.Activity;

import static android.os.Build.VERSION_CODES.R;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorder.Adapter.CartAdapter;
import com.example.foodorder.Adapter.CartAdapter;
import com.example.foodorder.Helper.ChangeNumberItemsListener;
import com.example.foodorder.Helper.ManagmentCart;
import com.example.foodorder.databinding.ActivityCartBinding;
import com.example.foodorder.R;

public class CartActivity extends AppCompatActivity {
    private ActivityCartBinding binding;
    private RecyclerView.Adapter adapter;
    private ManagmentCart managmentcart;
    private double tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managmentcart = new ManagmentCart(this);
        setVariable();
        calculateCart();
        initList();
    }

    private void initList() {
        if(managmentcart.getListCart().isEmpty()){
            binding.emtyTxt.setVisibility(View.VISIBLE);
            binding.scrollviewCart.setVisibility(View.GONE);
        }else{
            binding.emtyTxt.setVisibility(View.GONE);
            binding.scrollviewCart.setVisibility(View.VISIBLE);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        binding.cartView.setLayoutManager(LinearLayoutManager);
        adapter = new CartAdapter(managmentcart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void change(){
                calculateCart();
            }
        });
        binding.cartView.setAdapter(adapter);
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
    }

    private void calculateCart() {
        double percentTax = 0.05;
        double delivery = 10;

        tax = Math.round(managmentcart.getTotalFee() * percentTax * 100.0) / 100;
        double total = Math.round(managmentcart.getTotalFee() + tax + delivery) *100) / 100;
        double itemTotal = Math.round(managmentcart.getTotalFee()*100) / 100;

        binding.totalFeeTxt.setText("$" + itemTotal);
        binding.taxTxt.setText("$" + tax);
        binding.deliveryTxt.setText("$" + delivery);
        binding.totalTxt.setText("$" + total);
    }
}