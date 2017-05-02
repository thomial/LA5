package com.example.thomi.laporanakhir6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {

    EditText jumlah_barang;
    Spinner spinner;
    String Choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jumlah_barang = (EditText) findViewById(R.id.jumlah);
        spinner = (Spinner) findViewById(R.id.Spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.makanan, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    public void hitungharga(View v){

        float harga;
        switch (Choice.toLowerCase()){
            case "seblak":
                harga = 5000;
                break;
            case "cilor":
                harga = 10000;
                break;
            case "cokelat":
                harga = 25000;
                break;
            case "es buah":
                harga = 11000;
                break;
            case "mie goreng":
                harga = 15000;
                break;
            case "mie ayam":
                harga = 7000;
                break;
            case "nasi goreng":
                harga = 3000;
                break;
            case "ayam bakar":
                harga = 10000;
                break;
            default:
                harga = 0;
                break;

        }
        if (jumlah_barang.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Silahkan masukkan jumlah makanan", Toast.LENGTH_SHORT).show();
        }else {
            int jumlah = Integer.parseInt(jumlah_barang.getText().toString());
            float hasil = harga * jumlah;
            Toast.makeText(getApplicationContext(), "Anda memesan "+Choice+" sebanyak "+jumlah+" seharga RP."+hasil, Toast.LENGTH_SHORT ).show();
            jumlah_barang.setText("");
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Choice = String.valueOf(parent.getSelectedItem());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
