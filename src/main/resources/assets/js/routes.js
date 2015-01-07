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
     .when('/shoppingcart', {
        templateUrl: '/partials/shoppingcart.html',
        controller: 'WebShopController'
     }).when('#/article/:articleId', {
           templateUrl: '/partials/article.html',
           controller: 'WebShopController'
        })
     .otherwise({
        redirectTo: '/'
      });
  }]);
