breakDownApp.directive("selectInit", [function(){
	return {
		restrict: "A",
		link: function($scope){
			$('select').material_select();
		}
	}
}])

breakDownApp.directive("compareTo", [function(){
	return {
		require: "ngModel",
		restrict: "A",
		link: function($scope,element,attributes, ngModel){
			
		} 
	}
}])