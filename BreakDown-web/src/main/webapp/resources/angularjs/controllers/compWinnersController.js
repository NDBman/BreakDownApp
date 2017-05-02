breakDownApp.controller('compWinnersController', function($scope, $http, $location, $mdDialog, $rootScope){
	var compUrl = $location.url();
	if($rootScope.user == null){
		$location.path("/");
	}
	$http({
		method : 'GET',
		url : compUrl.substr(1,6)
	}).success(function(response){
		if(response.organizerId != $rootScope.user.id){
			$location.path("/");
		}
	}).error(function(){
		$location.path("/");
	})
	
	$scope.breakers;
	$scope.winnerDesc = [];
	$scope.winnerId = [];
	$http({
		method : 'GET',
		url : 'breaker/allfrom/' + compUrl.substr(1,6)
	}).success(function(response){
		$scope.breakers = response;
	}).error(function(){
		$location.path("/");
	})
	
	$scope.showPromt = function(ev,breakerId){
		var confirm = $mdDialog.prompt()
	      .title('Miben nyert a versenyző és milyen ehelyezést ért el?')
	      .placeholder('pl: 2v2 - 1.helyezet')
	      .targetEvent(ev)
	      .ok('Hozzáadás nyertesekhez')
	      .cancel('Mégse');
		
		$mdDialog.show(confirm).then(function(result) {
			if(result == ''|| result == null){
				result = 'Nincs megadva'
			}
			console.log(result);
			console.log(breakerId);
			$scope.winnerId.push(breakerId);
			$scope.winnerDesc.push(result);
			
		}, function() {
			cosole.log("nem lett nyertes");
		});
	}
	$scope.deleteFromWinners = function(breakerId){
		var index = $scope.winnerId.indexOf(breakerId);
		var desc = $scope.winnerDesc[index];
		$scope.winnerId.splice(index,1);
		$scope.winnerDesc.splice(index,1);
	}
	$scope.noWinners = false;
	$scope.finishComp = function(ids, descs){
		$http({
			method : 'POST',
			url: compUrl.substr(1,6) + '/finish',
			params : {
				winnerIds : ids,
				winnerDescriptions : descs
			}
		}).success(function(response){
			var path = '/comp/' + response.id;
			$location.path(path);
		}).error(function(error,status){
			if(status == 400){
				$scope.noWinners = true;
			}
		})
	}
})