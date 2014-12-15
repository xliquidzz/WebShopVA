var routes = angular.module('webshop.routes', ['ngRoute']);

routes.config(['$routeProvider',
  function($routeProvider) {
   	 /*.when('/', {
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
    */
     $routeProvider.when('/category/:name', {
        templateUrl: function(urlattr){
              return '/partials/' + urlattr.name;
        },
        controller: 'WebShopController'
     });
  }],['$resourceProvider', function($resourceProvider) {
    $resourceProvider.defaults.stripTrailingSlashes = false;
  }]);