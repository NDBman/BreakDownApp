breakDownApp.controller("newCompController", function($scope, $http, $location, $rootScope){
	if($rootScope.user == null){
		$location.path("/");
	}
	djNames = [];
	$scope.diskjockeys = angular.copy(djNames);
	$scope.events = [];
	$scope.isbreak = false;
	$scope.badTime= false;
	$scope.today = new Date();
	var now = new Date();
	$scope.compdate = new Date(now.getFullYear(), now.getMonth(), now.getDate()+1);
	$scope.badDate = false;
	$scope.submit = function(form){
		if(form.$invalid){
			return;
		}
		$http({
			method: "POST",
			url: "newcomp/newevent",
			params: {
				eventname : form.eventname.$modelValue,
				startTimeHour: form.startTimeHour.$modelValue,
				startTimeMinute: form.startTimeMinute.$modelValue,
				endTimeHour: form.endTimeHour.$modelValue,
				endTimeMinute: form.endTimeMinute.$modelValue,
				description: form.subeventd.$modelValue,
				isbreakevent: form.isbreak.$modelValue
			}
			
		}).success(function(response){
			
			$scope.events.push({
				title: response.title,
				startTime: response.startTime,
				endTime: response.endTime,
				description: response.description,
				breakevent: response.breakevent
			});
			$scope.eventname = "";
			$scope.startTimeHour = "";
			$scope.startTimeMinute = "";
			$scope.endTimeHour = "";
			$scope.endTimeMinute = "";
			$scope.subeventd = "";
			$scope.isbreak = false;
			$scope.badTime = false;
		}).error(function(){
			$scope.badTime = true;
		});
	}
	$scope.createComp = function(comp){
		$http({
			method: "POST",
			url:"newcomp/createcomp",
			params: {
				orgId : $rootScope.user.id,
				name : comp.name.$modelValue,
				compdate : moment(comp.compdate.$modelValue).format('L'),
				postalcode : comp.postalcode.$modelValue,
				city : comp.city.$modelValue,
				street : comp.street.$modelValue,
				housenumber : comp.housenumber.$modelValue,
				description: comp.description.$modelValue,
				diskjockeys: comp.diskjockeys.$modelValue,
				events: $scope.events
			}
		}).success(function(){
			$location.path("compsuccess");
		}).error(function(){
			$scope.badDate = true;
		})
	}
	$scope.deleteEvent = function(event){
		var index = $scope.events.indexOf(event);
		$scope.events.splice(index, 1);
	}
});