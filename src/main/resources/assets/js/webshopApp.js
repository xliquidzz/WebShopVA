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

webshopApp.factory('FoodList', function($resource){
    var url = '/api/food';
    return $resource(url);
});

webshopApp.controller('WebShopController',function($scope, Food, FoodList){
    $scope.foodList = FoodList.get();
    $scope.food = Food.get({id: 1});
});




