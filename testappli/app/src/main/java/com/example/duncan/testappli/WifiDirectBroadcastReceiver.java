package com.example.duncan.testappli;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.widget.Toast;

public class WifiDirectBroadcastReceiver extends BroadcastReceiver {

    private WifiP2pManager mManager;
    private WifiP2pManager.Channel mChannel;
    private WifiDirect mActivity;

    public WifiDirectBroadcastReceiver(WifiP2pManager mManager, WifiP2pManager.Channel mChannel, WifiDirect mainActivity)
    {
        this.mManager = mManager;
        this.mChannel = mChannel;
        this.mActivity= mActivity;
    }


@Override
    public void onReceive (Context context, Intent intent){
    String action = intent.getAction();
    if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
        // Determine if Wifi P2P mode is enabled or not, alert
        // the Activity.
        int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
        if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
            Toast.makeText(context, "Wifi ON", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Wifi OFF", Toast.LENGTH_SHORT).show();
        }

    } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {

        // The peer list has changed! We should probably do something about
        // that.
if (mManager != null){
    mManager.requestPeers(mChannel,mActivity.peerListListener);
}

    } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {

        // Connection state changed! We should probably do something about
        // that.

    } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {

    }
}



}
