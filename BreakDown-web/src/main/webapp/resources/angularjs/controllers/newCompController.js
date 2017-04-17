breakDownApp.controller("newCompController", function($scope, $http){
	djNames = [];
	$scope.diskjockeys = angular.copy(djNames);
	$scope.events = [];
	$scope.isbreak = false;
	$scope.badTime= false;
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
			console.log(response.isBreakEvent);
			console.log($scope.events);
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
				name : comp.name.$modelValue,
				compdate : comp.compdate.$modelValue,
				postalcode : comp.postalcode.$modelValue,
				city : comp.city.$modelValue,
				street : comp.street.$modelValue,
				housenumber : comp.housenumber.$modelValue,
				description: comp.description.$modelValue,
				diskjockeys: comp.diskjockeys.$modelValue,
				events: $scope.events
			}
		}).success(function(){
			console.log("hej!");
		}).error(function(){
			console.error("nah");
		})
	}
	$scope.deleteEvent = function(event){
		console.log(event);
		var index = $scope.events.indexOf(event);
		$scope.events.splice(index, 1);
	}
});