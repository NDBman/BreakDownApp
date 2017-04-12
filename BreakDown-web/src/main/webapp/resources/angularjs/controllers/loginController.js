breakDownApp.controller("loginController",function($scope, $rootScope, $http, $location){
	$scope.badData = false;
	$scope.submit = function(form){
		$http({
			method : "POST",
			url: "login",
			data : {
					email: form.email.$modelValue,
					password: form.password.$modelValue
			},
		}).success(function(response){
			$rootScope.authenticated = true;
			$rootScope.id = response.id;
			$rootScope.role = response.role;
			$location.path("/")
		}).error(function(){
			$scope.badData = true;
		});
	}
});