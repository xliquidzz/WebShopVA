
app.service('categoryService', function($resource, $routeParams) {
    this.allCategories = function(){
        var resource = $resource('/api/category');
        return resource.query();
    };

    this.currentCategory = function() {
        return $routeParams.currentCategory || 'start';
    }
});

app.service('articleService', function($resource, categoryService) {
    this.allArticles = function() {
        var resource = $resource('/api/article');
        return resource.query();
    };

    this.currentArticles = function() {
        var resource;
        console.log(categoryService.currentCategory())
        resource = $resource('/api/article/category/' + categoryService.currentCategory());
        return resource.query();
    };
});

app.service('shoppingCartService', function() {

    this.shoppingCartArticles = [];

    this.sum = 0;

    this.addArticleToShoppingCart = function(newArticle) {
        if(newArticle !== null) {
            this.shoppingCartArticles.push(newArticle);
        }
        this.sum = this.sum + newArticle.price;
    };

    this.removeArticleFromShoppingCart = function(index) {
        this.shoppingCartArticles.splice(index, 1);
        this.sum = this.sum - this.shoppingCartArticles[index].price;
    };

});

