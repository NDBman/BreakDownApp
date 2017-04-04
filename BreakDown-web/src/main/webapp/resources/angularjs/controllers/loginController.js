breakDownApp.controller("loginController",function($scope, $rootScope, $http, $location){
	$scope.submit = function(form){
		$http({
			method : "POST",
			url: "login",
			data : {
					username: form.username.$modelValue,
					password: form.password.$modelValue
			},
		}).success(function(response){
			$rootScope.authenticated = true;
			$rootScope.id = response.id;
			$rootScope.role = response.role.roleType;
			$location.path("/")
		}).error(function(){
			console.error("error");
		});
	}
});