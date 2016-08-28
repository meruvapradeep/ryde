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
		templateUrl: 'static/partials/home.html',
		controller: 'HomeController'
	})
	.state('home',{
        url: '/home',
		templateUrl: 'static/partials/home.html',
		controller: 'HomeController'
	})
	
	// Inventory routing
	.state('inventory',{
        url:'/inventory',
		templateUrl: 'static/partials/inventory.html',
		controller: 'InventoryController' 
	})
	.state('viewVehicle',{
        url:'/inventory/:id/view',
		templateUrl: 'static/partials/inventory-view.html',
		controller: 'InventoryViewController' 
	})
	.state('addVehicle',{
        url:'/inventory/new',
		templateUrl: 'static/partials/inventory-add.html',
		controller: 'InventoryAddController' 
	})
	.state('editVehicle',{
        url:'/inventory/:id/edit',
		templateUrl: 'static/partials/inventory-edit.html',
		controller: 'InventoryEditController' 
	})	
	
	// Customer routing 
	.state('customer',{
        url: '/customer',
		templateUrl: 'static/partials/customer.html',
		controller: 'CustomerController' 
	});
}).run(function($state) {
	$state.go('ryde');
});


