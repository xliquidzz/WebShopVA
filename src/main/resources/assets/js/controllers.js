var controllers = angular.module('webshop.controllers', []);

controllers.controller('FoodController', function($scope, $resource, Food, FoodList){
    $scope.foodList = FoodList;

    $scope.food = Food;
});

controllers.controller('ArticleController', function($scope, Article, ArticleList){
    $scope.articleList = ArticleList;

    $scope.article = Article;

    $scope.test = 'test';
});

controllers.controller('ShoppingCartController', function ($scope, ArticleService,){
    $scope.articles = ArticleService.articleList;

    $scope.addArticle = function(article) {
        ArticleService.articleList.push({
            articleDescription: article.description,
            articlePrice: article.price
        });
        ArticleService.sum = article.price + ArticleService.sum;
    };

    $scope.sum = ArticleService.sum;
}):