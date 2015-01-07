
app.service('categoryService', function($resource) {
    this.allCategories = function(){
        var resource = $resource('/api/category');
        return resource.query();
    };
});

app.service('articleService') {
    this.allArticles = function() {
        var resource = $resource('/api/article')
        return resource.query;
    };
};


