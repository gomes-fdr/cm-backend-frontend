angular.module('AppModule', ['ngRoute', 'PacienteController', 'ng.mask'])

.controller('AppController', ['$scope', '$location', function($scope, $location) {

    // gerar uma chave falsa para o registro
    $scope.getFakeID = function () {
         return Math.floor((Math.random() * 10000) + 500);
    };

    // função para redir de página disponível a todos os controllers
    $scope.redir = function (onde) {
         $location.path(onde);
    }
 
}])

.config(['$routeProvider', function ($routeProvider) {        
    $routeProvider.
    	// PADRÃO
        when('/', {
            templateUrl: 'html/greeting.html',
        }).
        // Pacientes
        when('/paciente-lista', {
            templateUrl: 'html/paciente-lista.html',
            controller: 'PacienteController'
        }). 
        when('/paciente-novo', {
            templateUrl: 'html/paciente-novo.html',
            controller: 'PacienteController'
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