package com.purdue.helloworld.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.purdue.helloworld.R;

public class NotificationsFragment extends Fragment {

    private WebView webView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final EditText editText = root.findViewById(R.id.passwordText);
        Button button = root.findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().trim().equals("123456")) {
                    Intent intent = new Intent(getContext(),uploadData.class);
                    startActivity(intent);
                }
            }
        });
/*
        webView = root.findViewById(R.id.webViewID);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.purdueexponent.org/features/article_a54b66d7-8d9d-5972-ba99-7ddbeef53d22.html");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
*/
        return root;
    }
}