package com.hedo.mytroopers;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.hedo.mytroopers.adapters.TrooperItemAdapter;
import com.hedo.mytroopers.domain.Trooper;
import com.hedo.mytroopers.domain.TroopersRepository;
import com.hedo.mytroopers.util.Constants;
import com.hedo.mytroopers.util.SharedPreferencesUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements TrooperItemAdapter.OnItemClickListener, View.OnLongClickListener {

    private RecyclerView rvTroopers;

    private TrooperItemAdapter trooperItemAdapter;

    private ArrayList<Trooper> troopers;

    private SharedPreferencesUtil sharedPreferencesUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
        populateRecyclerView();
    }

    @Override
    protected void onStop() {
        super.onStop();
        sharedPreferencesUtil.updateTroopers(troopers);
    }

    private void initializeComponents() {
        rvTroopers = findViewById(R.id.troopers_rv);
    }

    private void populateRecyclerView() {
        tryGettingTroopersFromSharedPrefs();
        trooperItemAdapter = new TrooperItemAdapter(troopers, this, this);

        rvTroopers.setLayoutManager(new LinearLayoutManager(this));
        rvTroopers.setAdapter(trooperItemAdapter);
    }

    private void tryGettingTroopersFromSharedPrefs() {
        sharedPreferencesUtil = new SharedPreferencesUtil(getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE));

        if (!sharedPreferencesUtil.hasSavedTroopers()) {
            troopers = TroopersRepository.getAll();
            sharedPreferencesUtil.updateTroopers(troopers);
        } else {
            troopers = sharedPreferencesUtil.getTroopers();
        }

    }

    @Override
    public void onItemClick(Trooper item) {
        Intent intent = new Intent(this, TrooperDetailActivity.class);
        intent.putExtra(Constants.EXTRA_TROOPER, item);

        startActivity(intent);
    }

    @Override
    public boolean onLongClick(final View v) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.trooper_delete_title)
                .setMessage(R.string.trooper_delete_msg)
                .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int position = rvTroopers.getChildLayoutPosition(v);
                        troopers.remove(position);
                        trooperItemAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this,
                                R.string.deleted_trooper_toast_msg,
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.nao, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();

        return true;
    }
}
