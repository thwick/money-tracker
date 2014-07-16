'use strict';

/* App Module */

var budgetApp = angular.module('budgetApp', [
  'ui.router',
  'budgetControllers',
  'budgetServices',
  'ngGrid',
  'ui.bootstrap'
]);

budgetApp.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
	

	$stateProvider.state('home', {
		url: "",
  		templateUrl: 'partials/home.html',
  		controller: 'HomeCtrl'
	})
	
	$stateProvider.state('categories', {
        templateUrl: 'partials/category-list.html',
        controller: 'CategoryListCtrl'
	})
	
	$stateProvider.state('accounts', {
        templateUrl: 'partials/account-list.html',
        controller: 'AccountListCtrl'
	})
	
	$stateProvider.state('account', {
		url: '/accounts/{id}',
        templateUrl: 'partials/account-detail.html',
        controller: 'AccountRegisterCtrl'
	})
	
	$urlRouterProvider.otherwise("/");
	
}]);

