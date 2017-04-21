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
		})
		.when("/comps",{
			templateUrl : "pages/competitions.html",
			controller : "compsController"
		})
		.when("/newcomp",{
			templateUrl : "pages/newcompetition.html",
			controller : "newCompController"
		})
		.when("/compsuccess",{
			templateUrl: "pages/compsuccess.html"
		})
		.when("/comp",{
			templateUrl : "pages/singlecomp.html"
		});
	
	$mdThemingProvider.theme("default")
	.primaryPalette("orange")
	.accentPalette("green")
	.warnPalette("red")
	.backgroundPalette("grey")
	.dark();
});


