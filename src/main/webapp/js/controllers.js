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
  function(conf,  $rootScope, $scope){
	$scope.title = conf.inventoryTitle;
});

// CustomerController
fmControllerModule.controller('CustomerController',
  function(conf, $rootScope, $scope){
	$scope.title = conf.customerTitle;
});