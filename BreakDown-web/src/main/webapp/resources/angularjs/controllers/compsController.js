breakDownApp.controller("compsController",function($scope, $http, $location, $rootScope){
	
//	var alreadySigned = function(){
//		if($rootScope.user == null || $scope.comp == null){
//			return "Jelentkezek";
//		}
//		for(var i = 0;i < $rootScope.user.competitions.length;i++){
//			if($rootScope.user.competitions[i].id == $scope.comp.id){
//				return "Lejelentkezek";
//			}
//		}
//		return "Jelentkezek";
//	};
	var alreadySigned = function(){
		if($rootScope.user != null){
			var signed = false;
			for(var i = 0;i < $rootScope.user.competitions.length;i++){
				
				for(var j = 0;j < $scope.cards.length;j++){
					
					if($rootScope.user.competitions[i].id == $scope.cards[j].id){
						signed = true;
					}
				}
			}
			if(signed){
				$scope.signUpToggle = "Lejelentkezek";
			}else{
				$scope.signUpToggle = "Jelentkezek";
			}
		}
	}
	$scope.cards = [];
	$http({
		method: "GET",
		url: "comps",
	}).success(function(response){
		$scope.cards = response;
		alreadySigned();
	});
	$scope.seeComp = function(compId){
		$location.path('comp/' + compId);
	}
	$scope.signUpDown = function(compId){
		$http({
			method : 'POST',
			url : 'comp/' + compId + '/signup',
			params : {
				email : $rootScope.user.email
			}
		}).success(function(response){
			$rootScope.user = response;
			alreadySigned();
		})
	}
});