angular.module('AppModule', ['ngRoute'])

.controller('AppController', ['$scope', function($scope) {

}])

.config(['$routeProvider', function ($routeProvider) {        
    $routeProvider.
    	// PADRÃO
        when('/', {
            templateUrl: 'html/greeting.html',
        }).
        // PADRÃO
        when('/sobre', {
            templateUrl: 'html/about.html',
        }).
        // PÁGINA NÃO PREVISTA
        when('/not-found', {
            templateUrl: 'html/not-found.html'
        }).
        otherwise({
            redirectTo: '/not-found'
        });
}]);       