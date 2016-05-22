angular.module('PacienteController', ['AppModule']).

controller('PacienteController', ['$scope', '$http', '$location', function($scope, $http, $location){
	
	$scope.urlAtual = $location.absUrl();

	var paciente = {};
	$scope.editarRegistro = false;


	$scope.todos = function() {

        // $http.get($scope.urlAtual + 'rest/pacientes').success(function (data) {

        $http.get('http://localhost:8080/cm/rest/pacientes').success(function (data) {
            $scope.listaPacientes = data;
            $scope.existemDados = true;

            // console.log('url: ' + $scope.urlAtual);
            // console.log($scope.listaPacientes);

        });
    };

    $scope.salvar = function() {
		if(!$scope.paciente.nome || !$scope.paciente.data) {
			alert('Campos obrigatórios não foram preenchidos!');
			return;
		}
		
		$scope.paciente.cpf = $scope.getFakeID();
		console.log($scope.paciente);
		console.log('ainda não bombou!');

		$http({
            method: 'POST',
            data: $scope.paciente,
            url: 'http://localhost:8080/cm/rest/pacientes',
            headers: {'Content-Type': 'application/json'}
        }).success(function (data, status, headers, config) {
            console.log(data);
            $scope.todos();
        }).error(function (data, status, headers, config) {
            console.log(data);
            $scope.todos();
        });

		$scope.redir('/paciente-lista');

    };

    $scope.excluir = function(paciente) {
    	console.log('paciente: ' + paciente.nome);
        $http.delete('http://localhost:8080/cm/rest/pacientes/' + paciente.cpf).success(function (data) {
            console.log(data);
            $scope.paciente = data;
            $scope.todos();
        });
    };

    $scope.editar = function(paciente) {
    	console.log("Editar paciente");
    	$scope.editarRegistro = true;
		$scope.paciente = angular.copy(paciente);

		var d = Date.parse(paciente.dt_nascimento);
		var formattedDate = moment(d).format('DD-MM-YYYY');

		$scope.paciente.dt_nascimento = formattedDate;
    };

    $scope.cancelarEdicao = function() {
    	console.log("Cancelar edição");
    	$scope.editarRegistro = false;
    };

    $scope.salvarEdicao = function(paciente) {
    	console.log("Salvar edição");
    	$scope.editarRegistro = false;

    	console.log(paciente.nome);
    	console.log('*** FALTA CONSEGUIR SALVAR !!!!');

    };

}]);