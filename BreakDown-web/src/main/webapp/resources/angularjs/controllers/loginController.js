breakDownApp.controller("loginController",function($scope, $rootScope, $http, $location){
	if($rootScope.user != null){
		$location.path("/");
	}
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
			$location.path("/")
		}).error(function(){
			$scope.badData = true;
		});
	}
});