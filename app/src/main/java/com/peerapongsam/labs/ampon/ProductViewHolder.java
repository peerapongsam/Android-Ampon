package com.peerapongsam.labs.ampon;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductViewHolder {
    ImageView productImage;
    TextView productName;
    TextView productPrice;
    EditText productQty;
    ImageButton btnAdd;
    ImageButton btnRemove;

    public ProductViewHolder(View itemView) {
        productImage = itemView.findViewById(R.id.product_image);
        productName = itemView.findViewById(R.id.product_name);
        productPrice = itemView.findViewById(R.id.product_price);
        btnAdd = itemView.findViewById(R.id.btn_add);
        btnRemove = itemView.findViewById(R.id.btn_remove);
        productQty = itemView.findViewById(R.id.qty);
    }

    public void bindValue(final Product product) {
        productImage.setImageResource(product.image);
        productName.setText(product.name);
        productPrice.setText(String.valueOf(product.price));
        productQty.setText(String.valueOf(product.qty));
//        productQty.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                try {
//
//                    Integer qty = Integer.valueOf(s.toString());
//                    if ()
//                    product.qty = qty;
//                } catch (Exception e) {
//                    //ignore
//                }
//            }
//        });
    }

    public void setOnAddClickListener(View.OnClickListener listener) {
        btnAdd.setOnClickListener(listener);
    }

    public void setOnRemoveClickListener(View.OnClickListener listener) {
        btnRemove.setOnClickListener(listener);
    }
}
