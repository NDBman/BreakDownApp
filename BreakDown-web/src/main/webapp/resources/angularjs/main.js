var breakDownApp = angular.module("BreakDownApp", ["ngMaterial", "ngMessages", "ngRoute"]);
breakDownApp.config(function($routeProvider, $mdThemingProvider){
	route = $routeProvider
		.when("/",{
			templateUrl : "pages/home.html",
			contoller : "mainController",
		})
		.when("/reg",{
			templateUrl : "pages/reg.html",
			controller : "regController",
		});
	
	$mdThemingProvider.theme("default")
	.primaryPalette("orange")
	.accentPalette("green")
	.warnPalette("red")
	.backgroundPalette("grey")
	.dark();
});

breakDownApp.controller("mainController", function($scope){
});

breakDownApp.controller("regController", function($scope){
	  
	$scope.birthday = new Date();
	
	$scope.passwordCheck = function(){
		if($scope.password == $scope.confirmPassword){
			$scope.dontMatch = false;
		}else{
			$scope.dontMatch = true;
		}
		
	};
});


