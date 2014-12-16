var webshopApp = angular.module('webshopApp', ['ngRoute','ngResource']);

webshopApp.value('currentCategory','food')

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
     .when('/category/:currentCategory', {
         templateUrl: '/partials/articles.html',
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

webshopApp.factory('ArticleFactory', function($rootScope, $resource, $routeParams) {
    $rootScope.currentCategory = $routeParams.currentCategory;
    var url = '/api/article/category/';
    if( $rootScope.currentCategory != null) {
        url = url + $rootScope.currentCategory;
    }
    return $resource(url).query();
});

webshopApp.factory('ShoppingCart', function() {
    return {
        shoppingList: []
    };
});

webshopApp.controller('WebShopController', function($scope,$rootScope,CategoryListFactory, ShoppingCart, ArticleFactory){

    if(ShoppingCart.shoppingList.length == 0){
        $rootScope.sum = 0;
    } else if ($rootScope.currentCategory == null) {
        $rootScope.currentCategory = 'food';
    }
    $scope.shoppingCart = ShoppingCart.shoppingList;

    $scope.categories = CategoryListFactory;

    $scope.$watch(function () {return ArticleFactory}, function (newVal, oldVal) {
            $scope.articles = ArticleFactory;
    });

    $scope.addArticleToShoppingList = function(article) {
        ShoppingCart.shoppingList.push({
            name: article.name,
            price: article.price
        });
        $rootScope.sum = $rootScope.sum + article.price;
    };
});





