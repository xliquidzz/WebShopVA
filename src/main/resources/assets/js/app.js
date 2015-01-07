var app = angular.module('webshopApp', ['ngRoute','ngResource']);



/*
webshopApp.factory('ArticleFactory', function ($rootScope, $resource, $routeParams) {

    var articles = [];

    function getArticles() {
        $rootScope.currentCategory = $routeParams.currentCategory;
        var url = '/api/article/category/';
        if(typeof($rootScope.currentCategory) != "undefined") {
            url = url + $rootScope.currentCategory;
        }
        var resource = $resource(url);
        $rootScope.articles = resource.query();
    }

    getArticles();

    return {
        articles: articles,
        getArticles: getArticles
    };
});*/






