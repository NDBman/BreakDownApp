var breakDownApp = angular.module("BreakDownApp", ["ngMaterial", "ngMessages", "ngRoute", "ngResource"]);
breakDownApp.config(function($routeProvider, $mdThemingProvider){
	route = $routeProvider
		.when("/",{
			templateUrl : "pages/home.html",
			contoller : "mainController",
		})
		.when("/reg",{
			templateUrl : "pages/reg.html",
			controller : "regController",
		})
		.when("/regsuccess",{
			templateUrl : "pages/regsuccess.html",
		});
	
	$mdThemingProvider.theme("default")
	.primaryPalette("orange")
	.accentPalette("green")
	.warnPalette("red")
	.backgroundPalette("grey")
	.dark();
});

breakDownApp.controller("mainController", function($scope){
	$scope.currentNavItem = "index";
});

breakDownApp
.controller("regController", function($scope, $http, $location){
	$scope.submittedForm = false;
	$scope.birthday = new Date();
	$scope.emailExits = false;
	
	$scope.passwordCheck = function(){
		if($scope.password == $scope.confirmPassword){
			$scope.dontMatch = false;
		}else{
			$scope.dontMatch = true;
		}
		
	};
	$scope.submit = function (form){
		if(form.$invalid)
			return;
		
		$http({
			method: "POST",
			url: "reg",
			params: {
				name: form.name.$modelValue,
				username: form.username.$modelValue,
				email: form.email.$modelValue,
				password: form.password.$modelValue,
				birthday: form.birthday.$modelValue,
				gender: form.gender.$modelValue
			}
		})
		.success(function(){
			$location.path("regsuccess");
		})
		.error(function(){
			$scope.emailExits = true;
		});
	}
	
	
	
});


