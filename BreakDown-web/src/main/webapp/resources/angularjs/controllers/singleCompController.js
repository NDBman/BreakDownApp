breakDownApp.controller('compDialogController', function($scope, $http){
});

breakDownApp.controller('singleCompController', function($scope, $location, $http, $rootScope, $mdDialog){
	var url = $location.url();
	$scope.comp;
	
	var alreadySigned = function(){
		if($rootScope.user == null || $scope.comp == null){
			return "Jelentkezek";
		}
		for(var i = 0;i < $rootScope.user.competitions.length;i++){
			if($rootScope.user.competitions[i].id == $scope.comp.id){
				return "Lejelentkezek";
			}
		}
		return "Jelentkezek";
	};
	
	$http({
		method : 'GET',
		url : url.substr(1)
	}).success(function(response){
		
		$scope.comp = response;
		$scope.signUpToggle = alreadySigned();
		$http({
			method : 'GET',
			url : 'comp/' + response.id + '/events'
		}).success(function(response){
			$scope.events = response;
		});
		$http({
			method : 'GET',
			url : 'breaker/' + $scope.comp.organizerId
		}).success(function(response){
			$scope.organizer = response.username;
		});
		$http({
			method : 'GET',
			url : 'comp/' + $scope.comp.id + '/competitors'
		}).success(function(response){
			$scope.competitors = response;
		});
	}).error(function(){
		$location.path("/");
	});
	
	$scope.showConfirm = function(ev){
		var confirm = $mdDialog.confirm()
			.title("Biztosan törölni akarja a versenyt?")
			.textContent("Később nem lesz képes visszavonni.")
			.clickOutsideToClose(true)
			.ok("Törlés")
			.cancel("Mégse");
		
		$mdDialog.show(confirm).then(function(){
			$http({
				method : 'DELETE',
				url : 'comp/' + $scope.comp.id + "/delete"
			}).success(function(){
				$location.path("comps");
			})
		}, function(){
		})
	};
	
	$scope.signUpDown = function(){
		$http({
			method : 'POST',
			url : 'comp/' + $scope.comp.id + '/signup',
			params : {
				email : $rootScope.user.email
			}
		}).success(function(response){
			$rootScope.user = response;
			$scope.signUpToggle = alreadySigned();
			$http({
				method : 'GET',
				url : url.substr(1,url.length)
			}).success(function(response){
				$scope.comp = response;
			})
		})
	};
	
	$scope.getCompetitors = function(ev){
		
		$mdDialog.show({
			controller: 'singleCompController',
			templateUrl : 'pages/competitorsdialog.html',
			parent: angular.element(document.body),
			targetEvent : ev,
			clickOutsideToClose: true,
			fullcreen : true
		})
		
	}
	$scope.finishComp = function(comp){
		$location.path("comp/" + comp.id + "/winners");
	}
	$scope.getUserName = function(winnerId){
		$http({
			method : 'GET',
			url: 'breaker/' + winnerId
		}).succes(function(response){
			return response;
		})
	} 
});
