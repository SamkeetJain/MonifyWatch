package com.sarl.monifywatch;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.db.chart.tooltip.Tooltip;
import com.db.chart.view.LineChartView;
import com.mikepenz.crossfadedrawerlayout.view.CrossfadeDrawerLayout;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.MiniDrawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.sarl.monifywatch.linechart.LineCardOne;

public class MainActivity extends AppCompatActivity {

    private AccountHeader headerResult = null;
    private Drawer result = null;
    private MiniDrawer miniResult = null;
    private CrossfadeDrawerLayout crossfadeDrawerLayout = null;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                .withHeaderBackground(R.drawable.reva_headerp)
//                .withHeaderBackground(R.drawable.header)
                /// TODO: 19-Oct-16
                .withSavedInstance(savedInstanceState)
                .build();

        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
//                .withDrawerLayout(R.layout.crossfade_councling_material_drawer)
                .withHasStableIds(true)
//                .withDrawerWidthDp(72)
//                .withGenerateMiniDrawer(false)
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("SMS").withIcon(R.drawable.ic_sms_black_24dp).withIdentifier(1),
                        new PrimaryDrawerItem().withName("Calls").withIcon(R.drawable.ic_call_black_24dp).withIdentifier(2),
                        new PrimaryDrawerItem().withName("Location").withIcon(R.drawable.ic_location_on_black_24dp).withIdentifier(3),
                        new PrimaryDrawerItem().withName("WhatsApp").withIcon(R.drawable.ic_giving_back_24dp).withIdentifier(4),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("Developers").withIcon(R.drawable.ic_android_black_24dp).withIdentifier(5)
                )
                // add the items we want to use with our Drawer
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem.getIdentifier() == 1) {

                        }
                        if (drawerItem.getIdentifier() == 2) {

                        }
                        if (drawerItem.getIdentifier() == 3) {

                        }
                        if (drawerItem.getIdentifier() == 4) {

                        }
                        if (drawerItem.getIdentifier() == 5) {

                        }
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(false)
                .build();


    }
}
