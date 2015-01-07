app.controller('WebShopController', function($scope,$rootScope,CategoryListFactory, ShoppingCart, ArticleFactory){

    if(ShoppingCart.shoppingList.length == 0){
        $rootScope.sum = 0;
    } else if ($rootScope.currentCategory == null) {
        $rootScope.currentCategory = 'food';
    }

    ArticleFactory.getArticles();

    $scope.shoppingCart = ShoppingCart.shoppingList;

    $scope.categories = CategoryListFactory;

    $scope.addArticleToShoppingList = function(article) {
        ShoppingCart.shoppingList.push({
            name: article.name,
            price: article.price
        });
        $rootScope.sum = $rootScope.sum + article.price;
    };

    $scope.removeArticleFromShoppingCart = function(index) {
        $rootScope.sum = $rootScope.sum - ShoppingCart.shoppingList[index].price;
        ShoppingCart.shoppingList.splice(index, 1);
    };

    $scope.allArticles = allArticles();
});