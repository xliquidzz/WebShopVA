app.controller('WebShopController', function($scope, articleService, categoryService, shoppingCartService){

    $scope.sum = shoppingCartService.sum;

    $scope.currentCategory = categoryService.currentCategory();

    $scope.articles = articleService.currentArticles();

    $scope.categories = categoryService.allCategories();

    $scope.shoppingCartArticles = shoppingCartService.shoppingCartArticles;

    $scope.addArticleToShoppingCart = function(art) {
        shoppingCartService.addArticleToShoppingCart(art);
        $scope.sum = shoppingCartService.sum;
    };

    $scope.removeArticleFromShoppingCart = function(index) {
        shoppingCartService.removeArticleFromShoppingCart(index);
        $scope.sum = shoppingCartService.sum;
    };
});

