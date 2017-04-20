breakDownApp.controller("compsController",function($scope, $http){
	$scope.cards = [];
	$http({
		method: "GET",
		url: "comps",
	}).success(function(response){
		$scope.cards = response;
	})
});