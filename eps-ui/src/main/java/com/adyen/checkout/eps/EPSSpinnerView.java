/*
 * Copyright (c) 2019 Adyen N.V.
 *
 * This file is open source and available under the MIT license. See the LICENSE file for more info.
 *
 * Created by arman on 12/6/2019.
 */

package com.adyen.checkout.eps;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import com.adyen.checkout.issuerlist.IssuerListSpinnerView;

@SuppressWarnings("AbbreviationAsWordInName")
public final class EPSSpinnerView extends IssuerListSpinnerView<EPSComponent> {
    private static final String TAG = LogUtil.getTag();

    public EPSSpinnerView(@NonNull Context context) {
        super(context);
    }

    public EPSSpinnerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EPSSpinnerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void attach(@NonNull EPSComponent component, @NonNull LifecycleOwner lifecycleOwner) {
        super.attach(component, lifecycleOwner);
        Logger.d(TAG, "attach");
        mComponent.observeOutputData(lifecycleOwner, createOutputDataObserver());
    }

    @Override
    public boolean hideIssuersLogo() {
        return true;
    }
}