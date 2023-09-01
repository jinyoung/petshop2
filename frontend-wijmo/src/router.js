
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PetProfileManager from "./grid/PetProfileGrid"
import PetProfileDetail from "./components/listers/PetProfileDetail"

import RecommendedProductManager from "./grid/RecommendedProductGrid"
import RecommendedProductDetail from "./components/listers/RecommendedProductDetail"

import PurchasedProductManager from "./grid/PurchasedProductGrid"
import PurchasedProductDetail from "./components/listers/PurchasedProductDetail"

import SocialMediaPostManager from "./grid/SocialMediaPostGrid"
import SocialMediaPostDetail from "./components/listers/SocialMediaPostDetail"

import ProductReviewManager from "./grid/ProductReviewGrid"
import ProductReviewDetail from "./components/listers/ProductReviewDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/petProfiles',
                name: 'PetProfileManager',
                component: PetProfileManager
            },
            {
                path: '/petProfiles/:id',
                name: 'PetProfileDetail',
                component: PetProfileDetail
            },

            {
                path: '/recommendedProducts',
                name: 'RecommendedProductManager',
                component: RecommendedProductManager
            },
            {
                path: '/recommendedProducts/:id',
                name: 'RecommendedProductDetail',
                component: RecommendedProductDetail
            },

            {
                path: '/purchasedProducts',
                name: 'PurchasedProductManager',
                component: PurchasedProductManager
            },
            {
                path: '/purchasedProducts/:id',
                name: 'PurchasedProductDetail',
                component: PurchasedProductDetail
            },

            {
                path: '/socialMediaPosts',
                name: 'SocialMediaPostManager',
                component: SocialMediaPostManager
            },
            {
                path: '/socialMediaPosts/:id',
                name: 'SocialMediaPostDetail',
                component: SocialMediaPostDetail
            },

            {
                path: '/productReviews',
                name: 'ProductReviewManager',
                component: ProductReviewManager
            },
            {
                path: '/productReviews/:id',
                name: 'ProductReviewDetail',
                component: ProductReviewDetail
            },



    ]
})
