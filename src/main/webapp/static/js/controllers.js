'use restrict';

var fmControllerModule = angular.module('ryde.controllers',[]);


// HomeController
fmControllerModule.controller('HomeController',
  function(conf, backendService, $rootScope, $scope){
	$scope.title = conf.homeTitle;
	
	// call service for data
	backendService.posts()
    .success(function(data) {
      $scope.data = data;
    })
    .error(function(error) {
      console.error(error);
    });
});

// InventoryController
fmControllerModule.controller('InventoryController',
  function(conf, inventoryService, popupService, $rootScope, $scope, $window, $state){
	$scope.vehicles = inventoryService.query();
	
	$scope.deleteVehicle = function(vehicle) { // Delete a vehicle
		console.log('Delete'+ vehicle.id);
	    if (popupService.showPopup('Really delete this?')) {
	    	vehicle.$delete({id: vehicle.id},function() {
	    	$state.go('inventory'); //redirect to home
	      }, function(error) {
	    	  console.log(error);
	    	  $state.go('inventory'); //redirect to home
	      });
	    }
	  };
	
});

//Inventory View Controller
fmControllerModule.controller('InventoryViewController',
  function(conf,  $rootScope, $scope){
	$scope.title = conf.inventoryTitle;
});

//Inventory Add Controller
fmControllerModule.controller('InventoryAddController',
  function(conf, inventoryService, $scope, $state, $stateParams){
	$scope.inventory = new inventoryService();
	$scope.addVehicle = function() {
		$scope.inventory.$save(function(){
			$state.go('inventory');
		});
	};
});

//InventoryController
fmControllerModule.controller('InventoryEditController',
  function(conf,  $rootScope, $scope){
	$scope.title = conf.inventoryTitle;
});
// CustomerController
fmControllerModule.controller('CustomerController',
  function(conf, $rootScope, $scope){
	$scope.title = conf.customerTitle;
});