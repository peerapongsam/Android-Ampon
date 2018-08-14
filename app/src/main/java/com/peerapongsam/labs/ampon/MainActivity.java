package com.peerapongsam.labs.ampon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ProductAdapter productAdapter = new ProductAdapter();
    private ListView listProduct;
    private Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        initView();
        getData();
    }

    private void bindView() {
        listProduct = findViewById(R.id.list_products);
        btnOrder = findViewById(R.id.btn_orders);
    }

    private void initView() {
        listProduct.setAdapter(productAdapter);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //หา Order ที่มี Qty มากกว่า 0
                ArrayList<Product> orders = new ArrayList<>();
                for (Product product : productAdapter.getProducts()) {
                    if (product.qty > 0) {
                        orders.add(product);
                    }
                }

                // เปิดหน้าใหม่
                if (orders.size() > 0) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putParcelableArrayListExtra("ORDERS", orders);
                    startActivity(intent);
                }
                Log.d(TAG, "onClick: " + orders);
            }
        });
    }

    private void getData() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "หมูทอดกระเทียม", 40.0, R.drawable.food_1));
        products.add(new Product(2, "ข้าวมันไก่", 40.0, R.drawable.food_2));
        products.add(new Product(3, "ข้าวหมูแดง", 40.0, R.drawable.food_3));
        products.add(new Product(4, "ข้าวผัดกระเพราไก่", 40.0, R.drawable.food_4));
        products.add(new Product(5, "ผัดผักบุ้ง", 40.0, R.drawable.food_5));
        products.add(new Product(6, "แกงจืดเต้าหู้หมูสับ", 40.0, R.drawable.food_6));
        products.add(new Product(7, "ผัดไท", 40.0, R.drawable.food_7));
        productAdapter.setProducts(products);
    }
}
