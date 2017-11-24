package com.hencoder.hencoderpracticedraw1;

import java.util.ArrayList;
import java.util.List;

/**
 * Android各版本所占的比例，name为版本名称，proportion为比例
 * Created by houlin on 2017/11/24.
 */

public class Data {

    public List<Bean> mList = new ArrayList<>();

    // 初始化数据
    {
        mList.add(new Bean("Gingerbread", 0.005f));
        mList.add(new Bean("Ice Cream Sandwich", 0.005f));
        mList.add(new Bean("Jelly Bean", 0.062f));
        mList.add(new Bean("KitKat", 0.138f));
        mList.add(new Bean("Lollipop", 0.272f));
        mList.add(new Bean("Marshmallow", 0.309f));
        mList.add(new Bean("Nougat", 0.206f));
        mList.add(new Bean("Oreo", 0.003f));
    }

    public class Bean {
        private String mName;
        private float mProportion;

        public Bean(String name, float proportion) {
            mName = name;
            mProportion = proportion;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }

        public float getProportion() {
            return mProportion;
        }

        public void setProportion(float proportion) {
            mProportion = proportion;
        }
    }
}
