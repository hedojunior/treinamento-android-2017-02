package com.hedo.troopersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hedo.troopersapp.model.Trooper;
import com.hedo.troopersapp.util.Constants;
import com.hedo.troopersapp.util.ResourceUtil;
import com.squareup.picasso.Picasso;

public class TrooperDetailActivity extends AppCompatActivity {

    private TextView tvTrooperDescription;
    private ImageView imvTrooperImage, imvTrooperAffiliation;
    private Trooper trooper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trooper_detail);
        initializeComponents();
        bindTrooper();
    }

    private void initializeComponents() {
        tvTrooperDescription = findViewById(R.id.trooper_description_tv);
        imvTrooperImage = findViewById(R.id.trooper_picture_imv);
        imvTrooperAffiliation = findViewById(R.id.trooper_affiliation_imv);
    }

    private void bindTrooper() {
        trooper = (Trooper) getIntent()
                .getSerializableExtra(Constants.TROOPER_EXTRA);
        tvTrooperDescription.setText(trooper.getDescription());
        imvTrooperAffiliation.setImageResource(ResourceUtil
                .getResourceBasedOnAffiliation(trooper.getAffiliation()));
        setTitle(trooper.getName());

        Picasso.with(this)
                .load(trooper.getImageUrl())
                .into(imvTrooperImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater()
                .inflate(R.menu.trooper_detail_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.star_item:
                Toast.makeText(this,
                        "FAVORITAR TROOPER",
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
