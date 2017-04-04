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
		.when("/login",{
			templateUrl : "pages/login.html",
			controller: "loginController"
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


