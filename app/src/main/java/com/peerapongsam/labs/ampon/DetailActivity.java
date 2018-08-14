package com.peerapongsam.labs.ampon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private TextView ordersResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        bindView();
        initView();
    }

    private void bindView() {
        ordersResult = findViewById(R.id.orders_list);
    }

    private void initView() {
        ordersResult.setText(Html.fromHtml(getOrders()));
    }

    private String getOrders() {
        StringBuilder builder = new StringBuilder();
        builder.append("<h1>รายการอาหารที่สั่ง</h1><br>================");
        ArrayList<Product> orders = getIntent().getParcelableArrayListExtra("ORDERS");
        Double totalPrice = 0.0;
        for (Product product : orders) {
            builder.append("<br>").append(product.name).append(" ราคา ").append(product.price).append(" จำนวน ").append(product.qty)
                    .append("").append(" รวม ").append(product.price * product.qty);
            totalPrice += (product.price * product.qty);
        }
        builder.append("</ul>");
        builder.append("<br>====================<br><br>");
        builder.append("<b>ราคารวม ").append(totalPrice).append("</b>");
        return builder.toString();
    }

}
