app.config(['$routeProvider',
  function($routeProvider) {
     $routeProvider
     .when('/', {
       templateUrl: 'partials/start.html',
       controller: 'WebShopController'
     })
     .when('/admin', {
        templateUrl: 'partials/admin.html',
        controller: 'AdminController'
     })
     .when('/category/:currentCategory', {
         templateUrl: '/partials/articles.html',
         controller: 'WebShopController'
     })
     .otherwise({
        redirectTo: '/'
      });
  }]);
