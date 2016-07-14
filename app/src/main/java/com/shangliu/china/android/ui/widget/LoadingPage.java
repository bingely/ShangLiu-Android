package com.shangliu.china.android.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.shangliu.china.android.R;
import com.shangliu.china.android.util.UIUtils;


/**
 * Created by Administrator on 2016/4/13.
 */
public abstract class LoadingPage extends FrameLayout {
    private Context mContext;
    private ResultState resultState = null;

    private LayoutParams lp;
    private View loadingView;

    private View errorView;

    private View emptyView;

    private View successView;


    private static final int PAGE_LOADINGVIEW_STATE = 1;
    private static final int PAGE_ERROR_STATE = 2;

    private static final int PAGE_EMPTY_STATE = 3;

    private static final int PAGE_SUCCESS_STATE = 4;

    private static final int PAGE_CURRENT_STATE = 4;

    public LoadingPage(Context context) {
        super(context, null);
    }

    public LoadingPage(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public LoadingPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {
        lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        if (loadingView == null) {
            loadingView = UIUtils.getXmlView(R.layout.page_loading);
            addView(loadingView, lp);
        }
        if (emptyView == null) {
            emptyView = UIUtils.getXmlView(R.layout.page_empty);
        }
        if (errorView == null) {
            errorView = UIUtils.getXmlView(R.layout.page_error);
        }

        showSafePage();
    }

    private void showSafePage() {
        UIUtils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                showPage();
            }
        });
    }

    private void showPage() {
        loadingView.setVisibility(PAGE_CURRENT_STATE == PAGE_LOADINGVIEW_STATE ? View.VISIBLE : View.GONE);
        emptyView.setVisibility(PAGE_CURRENT_STATE == PAGE_EMPTY_STATE ? View.VISIBLE : View.GONE);
        errorView.setVisibility(PAGE_CURRENT_STATE == PAGE_ERROR_STATE ? View.VISIBLE : View.GONE);

        if (successView != null) {
            successView = View.inflate(mContext, LayoutId(), null);   // 这里不能用UIUtils.getXmlView()？ // TODO: 2016/4/13
            addView(successView, lp);
        }
        successView.setVisibility(PAGE_CURRENT_STATE == PAGE_SUCCESS_STATE ? View.VISIBLE : View.GONE);
    }

    // TODO
    // show()
    // loadPage()
    public abstract int LayoutId();

    public enum ResultState {
        ERROR(2), EMPTY(3), SUCCESS(4);
        private int state;

        private String content;

        ResultState(int state) {
            this.state = state;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
