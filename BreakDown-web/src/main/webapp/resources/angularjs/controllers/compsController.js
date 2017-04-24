breakDownApp.controller("compsController",function($scope, $http, $location){
	
	$scope.cards = [];
	$http({
		method: "GET",
		url: "comps",
	}).success(function(response){
		$scope.cards = response;
	});
	$scope.seeComp = function(compId){
		$location.path('comp/' + compId);
	}
});