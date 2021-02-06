package com.dj.baeminpractice.model.data

import com.dj.baeminpractice.R
import com.dj.baeminpractice.model.BannerItem
import com.dj.baeminpractice.model.GridItem
import com.dj.baeminpractice.model.WhatToEat

val fakeBannerItemList = listOf(
    BannerItem(R.drawable.first),
    BannerItem(R.drawable.second),
    BannerItem(R.drawable.third),
    BannerItem(R.drawable.fourth),
    BannerItem(R.drawable.fifth)
)

val fakeGridItemList = listOf(
    GridItem(R.drawable.a, "1인분"),
    GridItem(R.drawable.b, "잇웃오더"),
    GridItem(R.drawable.c, "잇웃라이더스"),
    GridItem(R.drawable.d, "한식"),
    GridItem(R.drawable.e, "분식"),
    GridItem(R.drawable.f, "카페·디저트"),
    GridItem(R.drawable.g, "돈까스·회·일식"),
    GridItem(R.drawable.h, "치킨"),
    GridItem(R.drawable.i, "피자"),
    GridItem(R.drawable.j, "이시안·양식"),
    GridItem(R.drawable.k, "중국집"),
    GridItem(R.drawable.l, "족발·보쌈"),
    GridItem(R.drawable.m, "야식"),
    GridItem(R.drawable.n, "찜·탕"),
    GridItem(R.drawable.o, "도시락"),
    GridItem(R.drawable.p, "패스트푸드")
)

// 뭐먹지 리스트용!
val fakeWhatToEatList = listOf(
    WhatToEat("피자스쿨",
        "https://lh3.googleusercontent.com/proxy/ESq69OQPEof_YF-PrBdGx00GCBqj2f1Edmg6hr0jNa8p0ghiQml-v7JBIt3a9IIQ0gHHlWF82WNaYg-F5_8sppcVOWaDbVC-XNC0kU3Ih_l9EAPg1w",
        "이웃 1, 이웃 2, 이웃 3"),
    WhatToEat("햄버거",
        "https://images2.minutemediacdn.com/image/upload/c_crop,h_1126,w_2000,x_0,y_181/f_auto,q_auto,w_1100/v1554932288/shape/mentalfloss/12531-istock-637790866.jpg",
        "이웃 1, 이웃 2, 이웃 3, 이웃 4, 이웃 5"),
    WhatToEat("스테이크",
        "https://i2.wp.com/www.foodrepublic.com/wp-content/uploads/2012/05/testkitchen_argentinesteak.jpg?resize=1280%2C%20560&ssl=1",
        "이웃 1, 이웃 2"),
    WhatToEat("과일 샌드위치",
        "https://i0.wp.com/post.healthline.com/wp-content/uploads/2019/05/Various_Sandwiches_1296x728-header-1296x728.jpg?w=1155&h=1528",
        "이웃 1, 이웃 2, 이웃 3"),
    WhatToEat("샐러드",
        "https://images.unsplash.com/photo-1498837167922-ddd27525d352?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2850&q=80",
        "이웃 1, 이웃 2")
)