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
		.when("/comp/:id",{
			templateUrl : "pages/singlecomp.html",
			controller: 'singleCompController'
		}).when("/profil",{
			templateUrl : 'pages/profil.html',
			controller : 'profilController'
		}).when('/logout',{
			templateUrl : 'pages/logout.html',
			controller : 'logoutController'
		}).when('/error',{
			templateUrl : 'pages/error.html'
		}).when("/comp/:id/winners",{
			templateUrl : "pages/compwinners.html",
			controller: 'compWinnersController'
		}).when('/search/all',{
			templateUrl : 'pages/searchforbreakers.html',
			controller: 'searchBreakersController'
		}).when('/profil/:id',{
			templateUrl: 'pages/breakerprofil.html',
			controller : 'breakerProfilController'
		});
	
	$mdThemingProvider.theme("default")
	.primaryPalette("orange")
	.accentPalette("green")
	.warnPalette("red")
	.backgroundPalette("grey")
	.dark();
});


