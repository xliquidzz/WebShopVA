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

webshopApp.factory('FoodFactory', function($resource){
    var url = '/api/food/:id';
    return $resource(url);
});

webshopApp.controller('WebShopController',function($scope, FoodFactory){
    $scope.food = FoodFactory.get({id: 1}, function() {
        console.log(food);
    });
});




