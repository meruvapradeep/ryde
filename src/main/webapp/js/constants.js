'use restrict';

var fmConstantModule = angular.module('ryde.constants',[]);

fmConstantModule.value('conf',{
	appName: 'RYDE',
	indexTitle: 'Index Fleet Magic',
	homeTitle: 'Home',
	inventoryTitle: 'Inventory',
	customerTitle: 'Customers',
	date: 'YYYY-MM-DD HH:mm:ss'
});