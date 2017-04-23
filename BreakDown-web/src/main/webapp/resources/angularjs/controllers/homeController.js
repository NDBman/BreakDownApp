breakDownApp.controller('homeController',function($scope, $rootScope, $http, $location){
	$scope.compsInCities = [];
	var i;
	for(i = 0;i < $rootScope.user.interestedCities.length;i++){
		$http({
			method : 'GET',
			url : 'comps/' + $rootScope.user.interestedCities[i]
		}).success(function(response){
			if(response.length > 0){
				$scope.compsInCities.push({
					city : response[0].location.city,
					comp : response
				});
			}
			console.log($scope.compsInCities);
		})
	}
	$scope.seeComp = function(compId){
		$location.path('comp/' + compId);
	}
})