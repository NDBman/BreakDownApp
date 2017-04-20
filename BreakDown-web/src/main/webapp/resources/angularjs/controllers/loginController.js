breakDownApp.controller("loginController",function($scope, $rootScope, $http, $location){
	$scope.badData = false;
	$scope.submit = function(form){
		if(form.$invalid){
			return;
		}
		$http({
			method : "POST",
			url: "login",
			data : {
					email: form.email.$modelValue,
					password: form.password.$modelValue
			},
		}).success(function(response){
			$rootScope.user = response;
			console.log($rootScope.user);
			$location.path("/")
		}).error(function(){
			$scope.badData = true;
		});
	}
});