var webshopApp = angular.module('webshopApp', ['ngRoute','ngResource']);

webshopApp.config(['$routeProvider',
  function($routeProvider) {
     $routeProvider
     .when('/', {
       templateUrl: 'partials/start.html',
       controller: 'WebShopController'
     })
     .when('/admin', {
        templateUrl: 'partials/admin.html',
        controller: 'WebShopController'
     })
     .when('/category/:name', {
         templateUrl: function($scope, urlattr){
            $scope.category = urlattr;
            return '/partials/articles.html';
         },
         controller: 'WebShopController'
     })
     .otherwise({
        redirectTo: '/'
      });
  }],['$resourceProvider', function($resourceProvider) {
    $resourceProvider.defaults.stripTrailingSlashes = false;
  }]);

webshopApp.factory('CategoryListFactory', function($resource) {
    var resource = $resource('/api/category');
    return resource.query();
});

webshopApp.factory('ArticleFactory', function($resource) {
    var resource = $resource('/api/article  ');
    return resource.query();
});

webshopApp.factory('ShoppingCart', function() {
    return {
        shoppingList: [],
        sum: 0.0
    };
});

webshopApp.controller('WebShopController', function($scope, CategoryListFactory, ArticleFactory, ShoppingCart){

    $scope.sum = ShoppingCart.sum;

    $scope.shoppingCart = ShoppingCart.shoppingList;

    $scope.categories = CategoryListFactory;

    $scope.articles = ArticleFactory;

    $scope.addArticle = function(article) {
        ShoppingCart.shoppingList.push({
            name: article.name,
            price: article.price
        });
        ShoppingCart.sum = article.price + ShoppingCartService.sum;
    };
});





