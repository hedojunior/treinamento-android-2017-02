package com.hedo.mytroopers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hedo.mytroopers.domain.Trooper;
import com.hedo.mytroopers.util.Constants;
import com.hedo.mytroopers.util.DrawableUtil;
import com.squareup.picasso.Picasso;

public class TrooperDetailActivity extends AppCompatActivity {

    private TextView tvTrooperDescription;
    private ImageView ivTrooperPicture, ivTrooperAffiliance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trooper_detail);
        initializeComponents();
        Trooper trooper = (Trooper) getIntent().getSerializableExtra(Constants.EXTRA_TROOPER);

        if (trooper != null) {
            setTitle(trooper.getName());
            tvTrooperDescription.setText(trooper.getDescription());
            Picasso
                    .with(this)
                    .load(trooper.getPicture())
                    .into(ivTrooperPicture);

            ivTrooperAffiliance.setImageResource(DrawableUtil.getAffiliationDrawable(trooper.getAffiliation()));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.trooper_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fav_trooper_menu_icon:
                //TODO: favoritar trooper.
                Toast.makeText(this, "FAVORITAR TROOPER", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initializeComponents() {
        tvTrooperDescription = findViewById(R.id.trooper_description_tv);
        ivTrooperPicture = findViewById(R.id.trooper_picture_imv);
        ivTrooperAffiliance = findViewById(R.id.trooper_affiliation_imv);
    }
}
