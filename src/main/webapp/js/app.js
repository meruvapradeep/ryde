'use strict';

// Configure application Module
var ryde = angular.module('ryde',[
  'ngResource',
  'ryde.services',
  'ryde.controllers',
  'ryde.constants',
  'ui.router'
]);

// Configure routes for all views in fleetMagic application
ryde.config(
  function ($stateProvider) {
	$stateProvider
	.state('ryde',{
        url: '/',
		templateUrl: 'partials/home.html',
		controller: 'HomeController'
	})
	.state('home',{
        url: '/home',
		templateUrl: 'partials/home.html',
		controller: 'HomeController'
	})
	
	// Inventory routing
	.state('inventory',{
        url:'/inventory',
		templateUrl: 'partials/inventory.html',
		controller: 'InventoryController' 
	})
	.state('viewVehicle',{
        url:'/inventory/:id/view',
		templateUrl: 'partials/inventory-view.html',
		controller: 'InventoryViewController' 
	})
	.state('addVehicle',{
        url:'/inventory/new',
		templateUrl: 'partials/inventory-add.html',
		controller: 'InventoryAddController' 
	})
	.state('editVehicle',{
        url:'/inventory/:id/edit',
		templateUrl: 'partials/inventory-edit.html',
		controller: 'InventoryEditController' 
	})	
	
	// Customer routing 
	.state('customer',{
        url: '/customer',
		templateUrl: 'partials/customer.html',
		controller: 'CustomerController' 
	});
}).run(function($state) {
	$state.go('ryde');
});


