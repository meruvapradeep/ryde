'use strict';

// Configure application Module
var ryde = angular.module('ryde',[
  'ryde.controllers',
  'ryde.constants',
  'ryde.services',
  'ngRoute'

]);

// Configure routes for all views in fleetMagic application
ryde.config(
  function ($routeProvider) {
	$routeProvider
	.when('/',{
		templateUrl: 'partials/views/home.html',
		controller: 'HomeController'
	})
	.when('/home',{
		templateUrl: 'partials/views/home.html',
		controller: 'HomeController'
	})
	.when('/inventory',{
		templateUrl: 'partials/views/inventory.html',
		controller: 'InventoryController' 
	})
	.when('/customer',{
		templateUrl: 'partials/views/customer.html',
		controller: 'CustomerController' 
	})
});


