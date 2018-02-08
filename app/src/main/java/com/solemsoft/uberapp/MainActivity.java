package com.solemsoft.uberapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mVendedor,mCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVendedor=(Button)findViewById(R.id.vendedor);
        mCliente=(Button)findViewById(R.id.cliente);
    }

    public void llamaLoginVendedor(View view){
        Intent intent=new Intent(MainActivity.this,VendedorLoginActivity.class);
        startActivity(intent);
        finish();
        return;
    }

    public void llamaLoginComprador(View view){
        Intent intent=new Intent(MainActivity.this,ClienteLoginActivity.class);
        startActivity(intent);
        finish();
        return;

    }
}
