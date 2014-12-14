var webshopApp = angular.module('webshopApp', ['ngRoute','ngResource']);

webshopApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider
   	 .when('/', {
        templateUrl: 'partials/start.html',
        controller: 'WebShopController'
      })
     .when('/food', {
        templateUrl: 'partials/food.html',
        controller: 'WebShopController'
      })
     .when('/drinks', {
        templateUrl: 'partials/drinks.html',
        controller: 'WebShopController'
      })
     .otherwise({
        redirectTo: '/'
      });
  }],['$resourceProvider', function($resourceProvider) {
    $resourceProvider.defaults.stripTrailingSlashes = false;
  }]);

webshopApp.factory('Food', function($resource){
    var url = '/api/food/:id';
    return $resource(url);
});

webshopApp.factory('ArticleService', function() {
    return {
        articleList : [],
        sum: 0.0
    };
});

webshopApp.controller('WebShopController', function($scope, $resource, Food, ArticleService){
    var FoodList = $resource('/api/food');
    $scope.foodList = FoodList.query();

    $scope.food = Food.get({id: 1});

    $scope.articles = ArticleService.articleList;

    $scope.addArticle = function(article) {
        ArticleService.articleList.push({
            articleDescription: article.description,
            articlePrice: article.price
        });
        ArticleService.sum = article.price + ArticleService.sum;
    };

    $scope.sum = ArticleService.sum;
});



