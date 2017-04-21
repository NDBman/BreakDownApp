breakDownApp.controller("compsController",function($scope, $http, $location, $rootScope){
	$scope.cards = [];
	$scope.comp;
	$http({
		method: "GET",
		url: "comps",
	}).success(function(response){
		$scope.cards = response;
	});
	$scope.seeComp = function(compId){
		$http({
			method: 'GET',
			url : "comp/" + compId
		}).success(function(response){
			$location.path('comp');
			$rootScope.comp = response;
		});
	}
});