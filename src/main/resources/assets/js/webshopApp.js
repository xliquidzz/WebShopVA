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

webshopApp.factory('FoodFactory', function($http){
    return {
        getFood: function() {
            var url = "http://localhost:8080/food/1"
            $http.jsonp(url)
                .success(function(data){
                    console.log(data.found);
                });
        }
    };
});

webshopApp.controller('WebShopController',function($scope, FoodFactory){

});




