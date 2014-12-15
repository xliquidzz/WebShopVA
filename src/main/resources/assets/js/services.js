var services = angular.module('webshop.services',[]);

services.factory('ArticleService', function() {
    return {
        articleList : [],
        sum: 0.0
    };
});

services.factory('Food', function($resource) {
    var url = '/api/food/:id';
    var food = $resource(url);
    return food;
});

services.factory('FoodList', function($resource) {
    var foodList = $resource('/api/food');
    return foodList.query();
});

services.factory('Article', function($resource) {
    var url = '/api/article/:id';
    var article = $resource(url);
    return article;
});

services.factory('ArticleList', function($resource) {
    var articleList = $resource('/api/food');
    return articleList.query();
});

services.factory('FoodList', function($resource) {
    var articleList = $resource('/api/food');
    return articleList.query();
});